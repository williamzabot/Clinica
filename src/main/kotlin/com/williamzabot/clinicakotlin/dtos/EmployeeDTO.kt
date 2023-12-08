package com.williamzabot.clinicakotlin.dtos

import com.williamzabot.clinicakotlin.entities.Address
import com.williamzabot.clinicakotlin.entities.Employee
import java.io.Serializable

data class EmployeeDTO(
        var id: Long,
        var name: String,
        var email: String,
        var cpf: String,
        var addressId: Long
) : Serializable

fun Employee.toEmployeeDTO() = EmployeeDTO(id, name, email, cpf, address.id)
fun EmployeeDTO.toEmployee() = Employee(id, name, email, cpf, Address(addressId))
