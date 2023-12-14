package com.example.locking

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.redisson.api.RedissonClient
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Aspect
@Component
class RedissonLockAspect(
    private val redissonClient: RedissonClient,
    private val redissonTransactionCall: RedissonTransactionCall
) {
    @Around("@annotation(com.example.locking.RedissonLock)")
    @Throws(Throwable::class)
    fun lock(joinPoint: ProceedingJoinPoint): Any? {
        val redissonLock = (joinPoint.signature as MethodSignature).method.getAnnotation(RedissonLock::class.java)
        val lock = redissonClient.getLock(redissonLock.key)

        val parameterNames = (joinPoint.signature as MethodSignature).parameterNames
        val arguments = joinPoint.args
        var data = ""
        parameterNames.forEachIndexed { index, it ->
            if (it == "data") {
                data = arguments[index].toString()
            }
        }

        return try {
            val available = lock.tryLock(
                redissonLock.waitTime,
                redissonLock.leaseTime,
                redissonLock.timeUnit
            )

            if (!available) {
                println("$data lock 획득 실패")
                return false
            }
            println("$data lock 획득 성공")
            redissonTransactionCall.proceed(joinPoint)
        } catch (e: Exception) {
            throw RuntimeException()
        } finally {
            lock.unlock()
            println("$data lock 해제")
        }
    }
}


@Component
class RedissonTransactionCall {

    @Throws(Throwable::class)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun proceed(joinPoint: ProceedingJoinPoint): Any? {
        return joinPoint.proceed()
    }
}