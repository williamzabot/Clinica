package com.williamzabot.clinicakotlin.services

import com.williamzabot.clinicakotlin.dtos.HealthInsuranceDTO
import com.williamzabot.clinicakotlin.dtos.toHealthInsurance
import com.williamzabot.clinicakotlin.dtos.toHealthInsuranceDTO
import com.williamzabot.clinicakotlin.entities.HealthInsurance
import com.williamzabot.clinicakotlin.repositories.HealthInsuranceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class HealthInsuranceService(
        @Autowired
        private val repository: HealthInsuranceRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<HealthInsuranceDTO> {
        return repository.findAll().map {
            it.toHealthInsuranceDTO()
        }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): HealthInsuranceDTO? {
        return repository.findById(id).getOrNull()?.toHealthInsuranceDTO()
    }

    @Transactional
    fun save(healthInsurance: HealthInsurance): HealthInsuranceDTO {
        return repository.save(healthInsurance).toHealthInsuranceDTO()
    }

    @Transactional
    fun update(id: Long, healthInsuranceDTO: HealthInsuranceDTO): HealthInsurance {
        val healthInsuranceToUpdate: HealthInsurance = repository.getReferenceById(id)
        val newHealthInsurance = healthInsuranceDTO.toHealthInsurance()
        newHealthInsurance.id = healthInsuranceToUpdate.id
        return repository.save(newHealthInsurance)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}