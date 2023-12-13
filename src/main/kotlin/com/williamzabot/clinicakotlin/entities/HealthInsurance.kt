package com.williamzabot.clinicakotlin.entities

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tb_agreements")
data class HealthInsurance(
        var id: Long,
        val name: String,
        val rate: Double,
        val observation: String
)
