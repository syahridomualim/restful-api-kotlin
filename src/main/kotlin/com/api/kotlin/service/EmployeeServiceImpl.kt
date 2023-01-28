package com.api.kotlin.service

import com.api.kotlin.model.Employee
import com.api.kotlin.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.NoSuchElementException

@Service
class EmployeeServiceImpl @Autowired constructor(
    private val employeeRepository: EmployeeRepository
) : EmployeeService {
    override fun save(employee: Employee): Employee {
        return employeeRepository.save(employee)
    }

    override fun getEmployee(id: Int): Employee {
        return employeeRepository.findById(id).orElseThrow{
            NoSuchElementException("employee doesn't exist")
        }
    }

    override fun getEmployees(): List<Employee> {
        return employeeRepository.findAll()
    }

    override fun editEmployee(id: Int, name: String, email: String, address: String): Employee {
        val employee = employeeRepository.findById(id).orElseThrow {
            NoSuchElementException("employee doesn't exist")
        }
        employee.apply {
            this.name = name
            this.email = email
            this.address = address
        }

        return employeeRepository.save(employee)
    }

    override fun deleteEmployee(id: Int) {
        employeeRepository.deleteById(id)
    }
}