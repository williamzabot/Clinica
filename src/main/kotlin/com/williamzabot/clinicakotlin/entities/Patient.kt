package com.williamzabot.clinicakotlin.entities

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tb_patients")
class Patient() : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var name: String? = null
    var email: String? = null
    var cpf: String? = null
    var registerDate: LocalDate = LocalDate.now()

    @ManyToOne
    @JoinColumn(name = "address_id")
    var address: Address? = null

    constructor(
            id: Long,
            name: String?,
            email: String?,
            cpf: String?,
            registerDate: LocalDate,
            address: Address?
    ) : this() {
        this.id = id
        this.name = name
        this.email = email
        this.cpf = cpf
        this.registerDate = registerDate
        this.address = address
    }

    constructor(id: Long) : this() {
        this.id = id
    }

}