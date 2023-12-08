package com.williamzabot.clinicakotlin.controllers

import com.williamzabot.clinicakotlin.dtos.EmployeeDTO
import com.williamzabot.clinicakotlin.dtos.toEmployee
import com.williamzabot.clinicakotlin.dtos.toEmployeeDTO
import com.williamzabot.clinicakotlin.services.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("v1/employees")
class EmployeeController(
        @Autowired
        val service: EmployeeService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<EmployeeDTO>> {
        return ResponseEntity.ok().body(service.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<EmployeeDTO?> {
        val employeeDTO: EmployeeDTO? = service.findById(id)
        return if (employeeDTO != null) {
            ResponseEntity.ok().body(employeeDTO)
        } else {
            ResponseEntity.status(404).body(null)
        }
    }

    @PostMapping
    fun save(@RequestBody employeeDTO: EmployeeDTO): ResponseEntity<EmployeeDTO> {
        val created = service.save(employeeDTO.toEmployee())
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(created.id).toUri()
        return ResponseEntity.created(uri).body(created)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,
               @RequestBody employeeDTO: EmployeeDTO
    ): ResponseEntity<EmployeeDTO> {
        val employee = service.update(id, employeeDTO).toEmployeeDTO()
        return ResponseEntity.ok().body(employee)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}