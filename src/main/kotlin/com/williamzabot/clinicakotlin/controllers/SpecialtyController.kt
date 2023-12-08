package com.williamzabot.clinicakotlin.controllers

import com.williamzabot.clinicakotlin.dtos.SpecialtyDTO
import com.williamzabot.clinicakotlin.dtos.toSpecialty
import com.williamzabot.clinicakotlin.dtos.toSpecialtyDTO
import com.williamzabot.clinicakotlin.services.SpecialtyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("v1/specialties")
class SpecialtyController(
        @Autowired
        val service: SpecialtyService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<SpecialtyDTO>> {
        return ResponseEntity.ok().body(service.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<SpecialtyDTO?> {
        val specialty = service.findById(id)
        return if (specialty != null) {
            ResponseEntity.ok().body(specialty)
        } else {
            ResponseEntity.status(404).body(null)
        }
    }

    @GetMapping("/{id}/doctors")
    fun findDoctors(@PathVariable id: Long): ResponseEntity<SpecialtyDTO> {
        val specialtyDTO = service.findDoctors(id)
        return ResponseEntity.ok().body(specialtyDTO)
    }

    @PostMapping
    fun save(@RequestBody specialtyDTO: SpecialtyDTO): ResponseEntity<SpecialtyDTO> {
        val create = service.save(specialtyDTO.toSpecialty())
                .toSpecialtyDTO()
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(create.id).toUri()
        return ResponseEntity.created(uri).body(create)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,
               @RequestBody specialtyDTO: SpecialtyDTO
    ): ResponseEntity<SpecialtyDTO> {
        val specialty = service.update(id, specialtyDTO).toSpecialtyDTO()
        return ResponseEntity.ok().body(specialty)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}