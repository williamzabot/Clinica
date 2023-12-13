package com.williamzabot.clinicakotlin.repositories

import com.williamzabot.clinicakotlin.entities.Appointment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AppointmentRepository : JpaRepository<Appointment, Long>
