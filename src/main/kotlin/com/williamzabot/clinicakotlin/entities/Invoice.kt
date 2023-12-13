package com.williamzabot.clinicakotlin.entities

import java.time.Instant
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "tb_invoices")
data class Invoice(
        var id: Long,
        val value: Double,
        val date: Instant,
        @OneToOne
        @JoinColumn(name = "appointment_id")
        val appointment: Appointment
)