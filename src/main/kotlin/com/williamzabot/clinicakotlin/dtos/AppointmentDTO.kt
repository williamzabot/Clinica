package com.williamzabot.clinicakotlin.dtos

import com.williamzabot.clinicakotlin.entities.Appointment
import java.io.Serializable
import java.time.Instant

data class AppointmentDTO(
        var id: Long,
        val registerDate: Instant,
        val appointmentDate: Instant,
        val value: Double,
        val patient: PatientDTO,
        val doctor: DoctorDTO,
        val healthInsurance: HealthInsuranceDTO,
        val employee: EmployeeDTO
) : Serializable

fun AppointmentDTO.toAppointment() = Appointment(
        id = id,
        registerDate = registerDate,
        appointmentDate = appointmentDate,
        value = value,
        patient = patient.toPatient(),
        doctor = doctor.toDoctor(),
        healthInsurance = healthInsurance.toHealthInsurance(),
        employee = employee.toEmployee()
)

fun Appointment.toAppointmentDTO() = AppointmentDTO(
        id = id,
        registerDate = registerDate,
        appointmentDate = appointmentDate,
        value = value,
        patient = patient.toPatientDTO(),
        doctor = doctor.toDoctorDTO(),
        healthInsurance = healthInsurance.toHealthInsuranceDTO(),
        employee = employee.toEmployeeDTO()
)
