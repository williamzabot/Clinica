package com.williamzabot.clinicakotlin.entities

import java.time.Instant
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tb_invoices")
data class Invoice(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        val value: Double,
        val date: Instant,
        @OneToOne
        @JoinColumn(name = "appointment_id")
        val appointment: Appointment
)