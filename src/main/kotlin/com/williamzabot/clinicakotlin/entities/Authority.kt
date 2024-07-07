package com.williamzabot.clinicakotlin.entities

import java.io.Serializable
import jakarta.persistence.*

@Entity
@Table(name = "tb_authorities")
data class Authority(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        var role: String
) : Serializable
