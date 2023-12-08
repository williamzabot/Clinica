package com.williamzabot.clinicakotlin.services

import com.williamzabot.clinicakotlin.dtos.EmployeeDTO
import com.williamzabot.clinicakotlin.dtos.toEmployee
import com.williamzabot.clinicakotlin.dtos.toEmployeeDTO
import com.williamzabot.clinicakotlin.entities.Employee
import com.williamzabot.clinicakotlin.repositories.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class EmployeeService(
        @Autowired
        private val repository: EmployeeRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<EmployeeDTO> {
        return repository.findAll().map {
            it.toEmployeeDTO()
        }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): EmployeeDTO? {
        return repository.findById(id).getOrNull()?.toEmployeeDTO()
    }

    @Transactional
    fun save(employee: Employee): EmployeeDTO {
        return repository.save(employee).toEmployeeDTO()
    }

    @Transactional
    fun update(id: Long, employeeDTO: EmployeeDTO): Employee {
        val employeeToUpdate: Employee = repository.getReferenceById(id)
        val newEmployee = employeeDTO.toEmployee()
        newEmployee.id = employeeToUpdate.id
        return repository.save(newEmployee)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}