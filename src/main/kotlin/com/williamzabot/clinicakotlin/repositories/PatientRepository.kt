package com.williamzabot.clinicakotlin.repositories

import com.williamzabot.clinicakotlin.entities.Patient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientRepository : JpaRepository<Patient, Long>
