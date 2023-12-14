package com.example.locking

import java.util.concurrent.TimeUnit

@Retention(value = AnnotationRetention.RUNTIME)
@Target(allowedTargets = [AnnotationTarget.FUNCTION])
annotation class RedissonLock(
    val key: String,
    val timeUnit: TimeUnit = TimeUnit.SECONDS,
    val waitTime: Long = 10L, // 락 대기 시간
    val leaseTime: Long = 5L // 락 해제 시간
)