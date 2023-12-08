package com.williamzabot.clinicakotlin.services

import com.williamzabot.clinicakotlin.dtos.SpecialtyDTO
import com.williamzabot.clinicakotlin.dtos.toSpecialtyDTO
import com.williamzabot.clinicakotlin.entities.Specialty
import com.williamzabot.clinicakotlin.repositories.SpecialtyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class SpecialtyService(
        @Autowired
        private val repository: SpecialtyRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<SpecialtyDTO> {
        return repository.findAll().map {
            it.toSpecialtyDTO()
        }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): SpecialtyDTO? {
        return repository.findById(id).getOrNull()?.toSpecialtyDTO()
    }


    @Transactional(readOnly = true)
    fun findDoctors(id: Long): SpecialtyDTO {
        val specialty = repository.findById(id).getOrNull()
        return SpecialtyDTO(
                specialty?.id ?: 0,
                specialty?.name,
                specialty?.description,
                specialty?.doctors ?: emptyList()
        )

    }

    @Transactional
    fun save(specialty: Specialty): Specialty {
        return repository.save(specialty)
    }

    @Transactional
    fun update(id: Long, specialty: SpecialtyDTO): Specialty {
        val register = repository.getReferenceById(id)
        register.name = specialty.name
        register.description = specialty.description
        return repository.save(register)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

}