package com.williamzabot.clinicakotlin.entities

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tb_doctors")
class Doctor() : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var name: String? = null
    var email: String? = null
    var crm: String? = null
    var viaHealthInsurance: Boolean? = null

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    var specialty: Specialty? = null

    constructor(
            id: Long,
            name: String?,
            email: String?,
            crm: String?,
            viaHealthInsurance: Boolean?,
            specialty: Specialty?
    ) : this() {
        this.id = id
        this.name = name
        this.email = email
        this.crm = crm
        this.viaHealthInsurance = viaHealthInsurance
        this.specialty = specialty
    }

    constructor(id: Long) : this() {
        this.id = id
    }
}