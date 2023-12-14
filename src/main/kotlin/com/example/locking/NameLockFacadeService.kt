package com.example.locking

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class NameLockFacadeService(
    private val nameLockService: NameLockService,
    private val someDataRepository: SomeDataRepository
) {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun updateDataWithNamedLock(id: Long, data: String) {
        try {
            val available = someDataRepository.getLock(id.toString())

            if (available != 1L) {
                println("$data lock 획득 실패")
                return
            }

            println("$data lock 획득 성공")
            nameLockService.updateDataWithNamedLock(id, data)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            someDataRepository.releaseLock(id.toString())
        }
    }
}