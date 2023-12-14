package com.williamzabot.clinicakotlin.dtos

import com.williamzabot.clinicakotlin.entities.Invoice
import java.time.Instant

data class InvoiceDTO(
        val id: Long,
        val rate: Double,
        val date: Instant,
        val appointment: AppointmentDTO
)

fun Invoice.toInvoiceDTO() = InvoiceDTO(id, rate, date, appointment.toAppointmentDTO())
fun InvoiceDTO.toInvoice() = Invoice(id, rate, date, appointment.toAppointment())

