package com.williamzabot.clinicakotlin.services

import com.williamzabot.clinicakotlin.dtos.AppointmentDTO
import com.williamzabot.clinicakotlin.dtos.toAppointment
import com.williamzabot.clinicakotlin.dtos.toAppointmentDTO
import com.williamzabot.clinicakotlin.entities.Appointment
import com.williamzabot.clinicakotlin.repositories.AppointmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class AppointmentService(
        @Autowired
        private val repository: AppointmentRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<AppointmentDTO> {
        return repository.findAll().map {
            it.toAppointmentDTO()
        }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): AppointmentDTO? {
        return repository.findById(id).getOrNull()?.toAppointmentDTO()
    }

    @Transactional
    fun save(appointment: Appointment): AppointmentDTO {
        return repository.save(appointment).toAppointmentDTO()
    }

    @Transactional
    fun update(id: Long, appointmentDTO: AppointmentDTO): Appointment {
        val appointmentToUpdate: Appointment = repository.getReferenceById(id)
        val newAppointment = appointmentDTO.toAppointment()
        newAppointment.id = appointmentToUpdate.id
        return repository.save(newAppointment)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

}