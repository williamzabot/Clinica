package com.williamzabot.clinicakotlin.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tb_doctors")
data class Doctor(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        var name: String,
        var email: String,
        var crm: String,
        var viaHealthInsurance: Boolean,
        @ManyToOne
        @JoinColumn(name = "specialty_id")
        var specialty: Specialty
): Serializable