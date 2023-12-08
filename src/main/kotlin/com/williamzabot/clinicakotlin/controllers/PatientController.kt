package com.williamzabot.clinicakotlin.controllers

import com.williamzabot.clinicakotlin.dtos.PatientDTO
import com.williamzabot.clinicakotlin.dtos.toPatient
import com.williamzabot.clinicakotlin.dtos.toPatientDTO
import com.williamzabot.clinicakotlin.services.PatientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("v1/patients")
class PatientController(
        @Autowired
        val service: PatientService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<PatientDTO>> {
        return ResponseEntity.ok().body(service.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<PatientDTO?> {
        val patientDTO: PatientDTO? = service.findById(id)
        return if (patientDTO != null) {
            ResponseEntity.ok().body(patientDTO)
        } else {
            ResponseEntity.status(404).body(null)
        }
    }

    @PostMapping
    fun save(@RequestBody patientDTO: PatientDTO): ResponseEntity<PatientDTO> {
        val created = service.save(patientDTO.toPatient())
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(created.id).toUri()
        return ResponseEntity.created(uri).body(created)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,
               @RequestBody patientDTO: PatientDTO
    ): ResponseEntity<PatientDTO> {
        val doctor = service.update(id, patientDTO).toPatientDTO()
        return ResponseEntity.ok().body(doctor)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}