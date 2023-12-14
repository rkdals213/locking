package com.example.locking

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors


@SpringBootTest
class LockingApplicationTests @Autowired constructor(
    private val redissonService: RedissonService,
    private val nameLockFacadeService: NameLockFacadeService,
    private val someDataRepository: SomeDataRepository
) {

    @BeforeEach
    fun before() {
        someDataRepository.saveAndFlush(SomeDataTable(data = "Test Data"))
    }

    @Test
    fun redissonTest() {
        val threadCount = 10
        val executorService = Executors.newFixedThreadPool(5)
        val latch = CountDownLatch(threadCount)

        for (i in 0 until threadCount) {
            executorService.submit {
                try {
                    redissonService.updateDataWithRedisson(1L, "Update Data $i")
                } finally {
                    latch.countDown()
                }
            }
        }

        latch.await()
    }

    @Test
    fun namedLockTest() {
        val threadCount = 10
        val executorService = Executors.newFixedThreadPool(5)
        val latch = CountDownLatch(threadCount)

        for (i in 0 until threadCount) {
            executorService.submit {
                try {
                    nameLockFacadeService.updateDataWithNamedLock(1L, "Update Data $i")
                } finally {
                    latch.countDown()
                }
            }
        }

        latch.await()
    }

}
