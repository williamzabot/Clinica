package com.williamzabot.clinicakotlin.dtos

import com.williamzabot.clinicakotlin.entities.Login


data class LoginDTO(
        val id: Long,
        val email: String,
        val password: String,
        val authorities: Set<AuthorityDTO>
)

fun LoginDTO.toLogin() = Login(
        id = id,
        email = email,
        password = password,
        authorities = authorities.map {
            it.toAuthority()
        }.toSet()
)

fun Login.toLoginDTO() = LoginDTO(
        id = id,
        email = email,
        password = password,
        authorities = authorities.map {
            it.toAuthorityDTO()
        }.toSet()
)