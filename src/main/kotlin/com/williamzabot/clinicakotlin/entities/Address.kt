package com.williamzabot.clinicakotlin.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tb_addresses")
class Address() : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var street: String? = null
    var number: String? = null
    var complement: String? = null
    var neighborhood: String? = null
    var zipCode: String? = null
    var city: String? = null
    var state: String? = null

    constructor(
            id: Long,
            street: String?,
            number: String?,
            complement: String?,
            neighborhood: String?,
            zipCode: String?,
            city: String?,
            state: String?
    ) : this() {
        this.id = id
        this.street = street
        this.number = number
        this.complement = complement
        this.neighborhood = neighborhood
        this.zipCode = zipCode
        this.city = city
        this.state = state
    }

    constructor(id: Long) : this() {
        this.id = id
    }
}