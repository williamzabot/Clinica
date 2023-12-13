package com.williamzabot.clinicakotlin.controllers

import com.williamzabot.clinicakotlin.dtos.AppointmentDTO
import com.williamzabot.clinicakotlin.dtos.toAppointment
import com.williamzabot.clinicakotlin.dtos.toAppointmentDTO
import com.williamzabot.clinicakotlin.services.AppointmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("v1/appointments")
class AppointmentController(
        @Autowired
        val service: AppointmentService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<AppointmentDTO>> {
        return ResponseEntity.ok().body(service.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<AppointmentDTO?> {
        val appointmentDTO: AppointmentDTO? = service.findById(id)
        return if (appointmentDTO != null) {
            ResponseEntity.ok().body(appointmentDTO)
        } else {
            ResponseEntity.status(404).body(null)
        }
    }

    @PostMapping
    fun save(@RequestBody appointmentDTO: AppointmentDTO): ResponseEntity<AppointmentDTO> {
        val created = service.save(appointmentDTO.toAppointment())
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(created.id).toUri()
        return ResponseEntity.created(uri).body(created)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,
               @RequestBody appointmentDTO: AppointmentDTO
    ): ResponseEntity<AppointmentDTO> {
        val authority = service.update(id, appointmentDTO).toAppointmentDTO()
        return ResponseEntity.ok().body(authority)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}