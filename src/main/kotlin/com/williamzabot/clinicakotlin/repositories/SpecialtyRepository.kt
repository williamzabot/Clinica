package com.williamzabot.clinicakotlin.repositories

import com.williamzabot.clinicakotlin.entities.Specialty
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpecialtyRepository : JpaRepository<Specialty, Long>