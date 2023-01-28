package com.api.kotlin.repository

import com.api.kotlin.model.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee, Int> {
}