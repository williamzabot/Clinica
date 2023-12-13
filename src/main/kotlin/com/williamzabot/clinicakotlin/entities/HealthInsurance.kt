package com.williamzabot.clinicakotlin.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tb_agreements")
class HealthInsurance() : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var name: String? = null
    var rate: Double? = null
    var observation: String? = null

    constructor(
            id: Long,
            name: String?,
            rate: Double?,
            observation: String?
    ) : this() {
        this.id = id
        this.name = name
        this.rate = rate
        this.observation = observation
    }

    constructor(id: Long) : this() {
        this.id = id
    }
}
