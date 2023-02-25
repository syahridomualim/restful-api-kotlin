package com.api.kotlin.service

import com.api.kotlin.model.Employee

interface EmployeeService {
    // save a new employee
    fun save(employee: Employee): Employee
    // get employee by id
    fun getEmployee(id: Long): Employee
    // get all employees
    fun getEmployees(): List<Employee>?
    // edit a employee
    fun editEmployee(id: Long, name: String, email: String, address: String): Employee
    // delete a employee
    fun deleteEmployee(id: Long)
}