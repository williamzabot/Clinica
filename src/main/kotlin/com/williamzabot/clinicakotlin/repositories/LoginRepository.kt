package com.williamzabot.clinicakotlin.repositories

import com.williamzabot.clinicakotlin.entities.Login
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LoginRepository : JpaRepository<Login, Long>
