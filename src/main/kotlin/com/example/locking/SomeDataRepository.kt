package com.example.locking

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface SomeDataRepository: JpaRepository<SomeDataTable, Long> {
    @Query(value = "select get_lock(:key, 6000)", nativeQuery = true)
    fun getLock(@Param("key") key: String?): Long

    @Query(value = "select release_lock(:key)", nativeQuery = true)
    fun releaseLock(@Param("key") key: String?): Long
}