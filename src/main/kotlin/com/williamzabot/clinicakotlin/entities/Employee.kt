package com.williamzabot.clinicakotlin.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tb_employees")
class Employee() : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var name: String? = null
    var email: String? = null
    var cpf: String? = null

    @ManyToOne
    @JoinColumn(name = "address_id")
    var address: Address? = null

    constructor(
            id: Long = 0,
            name: String,
            email: String,
            cpf: String,
            address: Address? = null
    ) : this() {
        this.id = id
        this.name = name
        this.email = email
        this.cpf = cpf
        this.address = address
    }

    constructor(id: Long) : this() {
        this.id = id
    }
}