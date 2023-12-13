package com.williamzabot.clinicakotlin.services

import com.williamzabot.clinicakotlin.dtos.LoginDTO
import com.williamzabot.clinicakotlin.dtos.toLogin
import com.williamzabot.clinicakotlin.dtos.toLoginDTO
import com.williamzabot.clinicakotlin.entities.Login
import com.williamzabot.clinicakotlin.repositories.LoginRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class LoginService(
        @Autowired
        private val loginRepository: LoginRepository,
) {

    @Transactional(readOnly = true)
    fun findAll(): List<LoginDTO> {
        return loginRepository.findAll().map {
            it.toLoginDTO()
        }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): LoginDTO? {
        return loginRepository.findById(id).getOrNull()?.toLoginDTO()
    }

    @Transactional
    fun save(login: Login): LoginDTO {
        return loginRepository.save(login).toLoginDTO()
    }

    @Transactional
    fun update(id: Long, loginDTO: LoginDTO): Login {
        val loginToUpdate: Login = loginRepository.getReferenceById(id)
        val newLogin = loginDTO.toLogin()
        newLogin.id = loginToUpdate.id
        return loginRepository.save(newLogin)
    }

    fun delete(id: Long) {
        loginRepository.deleteById(id)
    }

}