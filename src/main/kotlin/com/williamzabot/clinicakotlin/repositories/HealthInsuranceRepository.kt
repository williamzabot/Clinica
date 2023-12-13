package com.williamzabot.clinicakotlin.repositories

import com.williamzabot.clinicakotlin.entities.HealthInsurance
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HealthInsuranceRepository : JpaRepository<HealthInsurance, Long>