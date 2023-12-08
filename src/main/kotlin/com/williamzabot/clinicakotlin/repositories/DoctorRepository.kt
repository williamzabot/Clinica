package com.williamzabot.clinicakotlin.repositories

import com.williamzabot.clinicakotlin.entities.Doctor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DoctorRepository : JpaRepository<Doctor, Long>