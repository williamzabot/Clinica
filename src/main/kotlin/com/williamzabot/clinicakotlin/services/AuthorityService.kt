package com.williamzabot.clinicakotlin.services

import com.williamzabot.clinicakotlin.dtos.AuthorityDTO
import com.williamzabot.clinicakotlin.dtos.toAuthority
import com.williamzabot.clinicakotlin.dtos.toAuthorityDTO
import com.williamzabot.clinicakotlin.entities.Authority
import com.williamzabot.clinicakotlin.repositories.AuthorityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class AuthorityService(
        @Autowired
        private val repository: AuthorityRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<AuthorityDTO> {
        return repository.findAll().map {
            it.toAuthorityDTO()
        }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): AuthorityDTO? {
        return repository.findById(id).getOrNull()?.toAuthorityDTO()
    }

    @Transactional
    fun save(authority: Authority): AuthorityDTO {
        return repository.save(authority).toAuthorityDTO()
    }

    @Transactional
    fun update(id: Long, authorityDTO: AuthorityDTO): Authority {
        val authorityToUpdate: Authority = repository.getReferenceById(id)
        val newAuthority = authorityDTO.toAuthority()
        newAuthority.id = authorityToUpdate.id
        return repository.save(newAuthority)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

}