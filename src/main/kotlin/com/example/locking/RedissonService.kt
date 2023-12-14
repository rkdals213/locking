package com.example.locking

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RedissonService(
    private val someDataRepository: SomeDataRepository
) {

    @Transactional
    @RedissonLock(key = "#{args[0]}")
    fun updateDataWithRedisson(id: Long, data: String) {
        val someData = someDataRepository.findByIdOrNull(id) ?: throw RuntimeException()
        println(someData)

        Thread.sleep(3000)

        someData.data = data
    }
}