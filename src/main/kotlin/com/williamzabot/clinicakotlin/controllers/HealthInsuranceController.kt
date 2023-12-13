package com.williamzabot.clinicakotlin.controllers

import com.williamzabot.clinicakotlin.dtos.HealthInsuranceDTO
import com.williamzabot.clinicakotlin.dtos.toHealthInsurance
import com.williamzabot.clinicakotlin.dtos.toHealthInsuranceDTO
import com.williamzabot.clinicakotlin.services.HealthInsuranceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("v1/agreements")
class HealthInsuranceController(
        @Autowired
        val service: HealthInsuranceService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<HealthInsuranceDTO>> {
        return ResponseEntity.ok().body(service.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<HealthInsuranceDTO?> {
        val healthInsuranceDTO: HealthInsuranceDTO? = service.findById(id)
        return if (healthInsuranceDTO != null) {
            ResponseEntity.ok().body(healthInsuranceDTO)
        } else {
            ResponseEntity.status(404).body(null)
        }
    }

    @PostMapping
    fun save(@RequestBody healthInsuranceDTO: HealthInsuranceDTO): ResponseEntity<HealthInsuranceDTO> {
        val created = service.save(healthInsuranceDTO.toHealthInsurance())
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(created.id).toUri()
        return ResponseEntity.created(uri).body(created)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,
               @RequestBody healthInsuranceDTO: HealthInsuranceDTO
    ): ResponseEntity<HealthInsuranceDTO> {
        val employee = service.update(id, healthInsuranceDTO).toHealthInsuranceDTO()
        return ResponseEntity.ok().body(employee)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}