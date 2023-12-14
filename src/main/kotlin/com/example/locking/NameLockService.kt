package com.example.locking

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NameLockService(
    private val someDataRepository: SomeDataRepository
) {
    @Transactional
    fun updateDataWithNamedLock(id: Long, data: String) {
        val someData = someDataRepository.findByIdOrNull(id) ?: throw RuntimeException()
        println(someData)

        Thread.sleep(3000)

        someData.data = data
    }
}