package com.williamzabot.clinicakotlin.services

import com.williamzabot.clinicakotlin.dtos.DoctorDTO
import com.williamzabot.clinicakotlin.dtos.toDoctor
import com.williamzabot.clinicakotlin.dtos.toDoctorDTO
import com.williamzabot.clinicakotlin.entities.Doctor
import com.williamzabot.clinicakotlin.repositories.DoctorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class DoctorService(
        @Autowired
        private val repository: DoctorRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<DoctorDTO> {
        return repository.findAll().map {
            it.toDoctorDTO()
        }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): DoctorDTO? {
        return repository.findById(id).getOrNull()?.toDoctorDTO()
    }

    @Transactional
    fun save(doctor: Doctor): DoctorDTO {
        return repository.save(doctor).toDoctorDTO()
    }

    @Transactional
    fun update(id: Long, doctorDTO: DoctorDTO): Doctor {
        val doctorToUpdate: Doctor = repository.getReferenceById(id)
        val newDoctor = doctorDTO.toDoctor()
        newDoctor.id = doctorToUpdate.id
        return repository.save(newDoctor)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

}