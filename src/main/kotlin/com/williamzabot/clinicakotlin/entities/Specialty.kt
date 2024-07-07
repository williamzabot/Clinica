package com.williamzabot.clinicakotlin.entities

import java.io.Serializable
import jakarta.persistence.*

@Entity
@Table(name = "tb_specialties")
class Specialty() : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var name: String? = null

    @Column(columnDefinition = "TEXT")
    var description: String? = null

    @OneToMany(mappedBy = "specialty")
    var doctors: MutableList<Doctor> = mutableListOf()

    constructor(name: String?, description: String?) : this() {
        this.name = name
        this.description = description
    }

    constructor(id: Long) : this() {
        this.id = id
    }
}

