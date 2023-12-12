package com.williamzabot.clinicakotlin.dtos

import com.williamzabot.clinicakotlin.entities.Authority
import java.io.Serializable

data class AuthorityDTO(
        val id: Long,
        val role: String
) : Serializable


fun AuthorityDTO.toAuthority() = Authority(
        id = id,
        role = role
)

fun Authority.toAuthorityDTO() = AuthorityDTO(
        id = id,
        role = role
)

