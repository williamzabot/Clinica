package com.williamzabot.clinicakotlin.controllers

import com.williamzabot.clinicakotlin.dtos.DoctorDTO
import com.williamzabot.clinicakotlin.dtos.toDoctor
import com.williamzabot.clinicakotlin.dtos.toDoctorDTO
import com.williamzabot.clinicakotlin.services.DoctorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("v1/doctors")
class DoctorController(
        @Autowired
        val service: DoctorService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<DoctorDTO>> {
        return ResponseEntity.ok().body(service.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<DoctorDTO?> {
        val doctorDTO: DoctorDTO? = service.findById(id)
        return if (doctorDTO != null) {
            ResponseEntity.ok().body(doctorDTO)
        } else {
            ResponseEntity.status(404).body(null)
        }
    }

    @PostMapping
    fun save(@RequestBody doctorDTO: DoctorDTO): ResponseEntity<DoctorDTO> {
        val created = service.save(doctorDTO.toDoctor())
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(created.id).toUri()
        return ResponseEntity.created(uri).body(created)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,
               @RequestBody doctorDTO: DoctorDTO
    ): ResponseEntity<DoctorDTO> {
        val doctor = service.update(id, doctorDTO).toDoctorDTO()
        return ResponseEntity.ok().body(doctor)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}