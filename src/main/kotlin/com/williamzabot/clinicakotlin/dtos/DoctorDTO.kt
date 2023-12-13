package com.williamzabot.clinicakotlin.dtos

import com.williamzabot.clinicakotlin.entities.Doctor
import com.williamzabot.clinicakotlin.entities.Specialty
import java.io.Serializable

data class DoctorDTO(
        val id: Long,
        val name: String?,
        val email: String?,
        val crm: String?,
        val viaHealthInsurance: Boolean?,
        val specialtyId: Long
) : Serializable

fun DoctorDTO.toDoctor() = Doctor(
        id = id,
        name = name,
        email = email,
        crm = crm,
        viaHealthInsurance = viaHealthInsurance,
        specialty = Specialty(specialtyId)
)

fun Doctor.toDoctorDTO() = DoctorDTO(
        id = id,
        name = name,
        email = email,
        crm = crm,
        viaHealthInsurance = viaHealthInsurance,
        specialtyId = specialty?.id ?: 0
)