package com.williamzabot.clinicakotlin.dtos

import com.williamzabot.clinicakotlin.entities.Address
import java.io.Serializable

data class AddressDTO(
        val id: Long,
        val street: String?,
        val number: String?,
        val complement: String?,
        val neighborhood: String?,
        val zipCode: String?,
        val city: String?,
        val state: String?
) : Serializable

fun AddressDTO.toAddress() = Address(
        id = id,
        street = street,
        number = number,
        complement = complement,
        neighborhood = neighborhood,
        zipCode = zipCode,
        city = city,
        state = state
)

fun Address.toAddressDTO() = AddressDTO(
        id = id,
        street = street,
        number = number,
        complement = complement,
        neighborhood = neighborhood,
        zipCode = zipCode,
        city = city,
        state = state
)
