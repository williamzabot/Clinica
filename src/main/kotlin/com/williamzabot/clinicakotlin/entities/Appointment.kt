package com.williamzabot.clinicakotlin.entities

import java.io.Serializable
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "tb_appointments")
data class Appointment(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        val registerDate: Instant,
        val appointmentDate: Instant,
        val value: Double,
        @ManyToOne
        @JoinColumn(name = "patient_id")
        val patient: Patient,
        @ManyToOne
        @JoinColumn(name = "doctor_id")
        val doctor: Doctor,
        @ManyToOne
        @JoinColumn(name = "health_insurance_id")
        val healthInsurance: HealthInsurance,
        @ManyToOne
        @JoinColumn(name = "employee_id")
        val employee: Employee
) : Serializable