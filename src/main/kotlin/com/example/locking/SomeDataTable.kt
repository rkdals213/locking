package com.example.locking

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class SomeDataTable(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    var data: String
) {

    override fun toString(): String {
        return "SomeDataTable(id=$id, data='$data')"
    }
}