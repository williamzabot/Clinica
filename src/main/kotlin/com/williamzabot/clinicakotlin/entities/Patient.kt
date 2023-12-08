package com.williamzabot.clinicakotlin.entities

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tb_patients")
data class Patient(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        var name: String,
        var email: String,
        var cpf: String,
        var registerDate: LocalDate,
        @ManyToOne
        @JoinColumn(name = "address_id")
        var address: Address
): Serializable