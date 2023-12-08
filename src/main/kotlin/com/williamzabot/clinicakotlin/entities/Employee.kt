package com.williamzabot.clinicakotlin.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tb_employees")
data class Employee(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        var name: String,
        var email: String,
        var cpf: String,
        @ManyToOne
        @JoinColumn(name = "address_id")
        var address: Address
): Serializable