package com.williamzabot.clinicakotlin.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tb_authorities")
data class Authority(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        var role: String
) : Serializable
