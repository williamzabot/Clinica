package com.williamzabot.clinicakotlin.dtos

import com.williamzabot.clinicakotlin.entities.Address
import com.williamzabot.clinicakotlin.entities.Patient
import java.io.Serializable
import java.time.LocalDate

data class PatientDTO(
        val id: Long,
        val name: String?,
        val email: String?,
        val cpf: String?,
        val registerDate: LocalDate = LocalDate.now(),
        val addressId: Long?
) : Serializable

fun Patient.toPatientDTO() = PatientDTO(
        id = id,
        name = name,
        email = email,
        cpf = cpf,
        registerDate = registerDate,
        addressId = address?.id
)

fun PatientDTO.toPatient() = Patient(
        id = id,
        name = name,
        email = email,
        cpf = cpf,
        registerDate = registerDate,
        address = Address(addressId ?: 0)
)