package com.api.kotlin.controller

import com.api.kotlin.model.Employee
import com.api.kotlin.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/employees")
class EmployeeController @Autowired constructor(
    private val employeeService: EmployeeService
) {

    @PostMapping
    fun saveEmployee(@RequestBody employee: Employee): ResponseEntity<Employee> =
        ResponseEntity.ok(employeeService.save(employee))

    @GetMapping("/{id}")
    fun getEmployee(@PathVariable id: Long): ResponseEntity<Employee> =
        ResponseEntity.ok(employeeService.getEmployee(id))

    @GetMapping
    fun getEmployees(): ResponseEntity<List<Employee>> {
        val employees = employeeService.getEmployees()
        if (employees == null) {
            ResponseEntity.ok(Collections.EMPTY_LIST)
        }
        return ResponseEntity.ok(employees)
    }

    @PutMapping("/{id}")
    fun editEmployee(
        @PathVariable id: Long,
        @RequestParam name: String,
        @RequestParam email: String,
        @RequestParam address: String
    ): ResponseEntity<Employee> =
        ResponseEntity.ok(employeeService.editEmployee(id, name, email, address))

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<String> {
        employeeService.deleteEmployee(id)
        return ResponseEntity("resource deleted successfully", HttpStatus.OK)
    }
}