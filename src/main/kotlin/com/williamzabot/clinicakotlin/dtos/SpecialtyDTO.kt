package com.williamzabot.clinicakotlin.dtos

import com.williamzabot.clinicakotlin.entities.Specialty
import java.io.Serializable

class SpecialtyDTO() : Serializable {

    var id: Long = 0
    var name: String? = null
    var description: String? = null
    val doctors = ArrayList<DoctorDTO>()

    constructor(id: Long, name: String?, description: String?) : this() {
        this.id = id
        this.name = name
        this.description = description
    }

    constructor(id: Long, name: String?, description: String?, doctors: List<DoctorDTO>) : this() {
        this.id = id
        this.name = name
        this.description = description
        doctors.forEach {
            this.doctors.add(it)
        }
    }
}

fun SpecialtyDTO.toSpecialty() = Specialty(
        name = this.name,
        description = this.description
)

fun Specialty.toSpecialtyDTO() = SpecialtyDTO(
        id = this.id,
        name = this.name,
        description = this.description
)
