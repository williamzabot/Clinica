package com.williamzabot.clinicakotlin.dtos

import com.williamzabot.clinicakotlin.entities.*
import java.io.Serializable
import java.time.Instant

data class AppointmentDTO(
        var id: Long,
        val registerDate: Instant = Instant.now(),
        val appointmentDate: Instant,
        val rate: Double,
        val patientId: Long,
        val doctorId: Long,
        val healthInsuranceId: Long,
        val employeeId: Long
) : Serializable

fun AppointmentDTO.toAppointment() = Appointment(
        id = id,
        registerDate = registerDate,
        appointmentDate = appointmentDate,
        rate = rate,
        patient = Patient(patientId),
        doctor = Doctor(doctorId),
        healthInsurance = HealthInsurance(healthInsuranceId),
        employee = Employee(employeeId)
)

fun Appointment.toAppointmentDTO() = AppointmentDTO(
        id = id,
        registerDate = registerDate,
        appointmentDate = appointmentDate,
        rate = rate,
        patientId = patient.id,
        doctorId = doctor.id,
        healthInsuranceId = healthInsurance.id,
        employeeId = employee.id
)
