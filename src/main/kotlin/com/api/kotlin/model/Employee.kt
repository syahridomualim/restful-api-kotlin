package com.api.kotlin.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Employee(
    @Id
    val id: Long? = null,
    var name: String,
    var email: String,
    var address: String
)