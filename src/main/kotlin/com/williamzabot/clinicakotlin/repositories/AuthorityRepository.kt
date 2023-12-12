package com.williamzabot.clinicakotlin.repositories

import com.williamzabot.clinicakotlin.entities.Authority
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorityRepository : JpaRepository<Authority, Long>