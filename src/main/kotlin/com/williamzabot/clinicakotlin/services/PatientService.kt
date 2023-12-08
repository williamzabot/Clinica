package com.williamzabot.clinicakotlin.services

import com.williamzabot.clinicakotlin.dtos.PatientDTO
import com.williamzabot.clinicakotlin.dtos.toPatient
import com.williamzabot.clinicakotlin.dtos.toPatientDTO
import com.williamzabot.clinicakotlin.entities.Patient
import com.williamzabot.clinicakotlin.repositories.PatientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class PatientService(
        @Autowired
        private val repository: PatientRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<PatientDTO> {
        return repository.findAll().map {
            it.toPatientDTO()
        }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): PatientDTO? {
        return repository.findById(id).getOrNull()?.toPatientDTO()
    }

    @Transactional
    fun save(patient: Patient): PatientDTO {
        return repository.save(patient).toPatientDTO()
    }

    @Transactional
    fun update(id: Long, patientDTO: PatientDTO): Patient {
        val patientToUpdate: Patient = repository.getReferenceById(id)
        val newPatient = patientDTO.toPatient()
        newPatient.id = patientToUpdate.id
        return repository.save(newPatient)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}