package com.williamzabot.clinicakotlin.dtos

import com.williamzabot.clinicakotlin.entities.HealthInsurance

data class HealthInsuranceDTO(
        val id: Long,
        val name: String?,
        val rate: Double?,
        val observation: String?
)

fun HealthInsurance.toHealthInsuranceDTO() = HealthInsuranceDTO(
        id = id,
        name = name,
        rate = rate,
        observation = observation
)

fun HealthInsuranceDTO.toHealthInsurance() = HealthInsurance(
        id = id,
        name = name,
        rate = rate,
        observation = observation
)