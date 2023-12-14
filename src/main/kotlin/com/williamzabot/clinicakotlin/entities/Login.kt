package com.williamzabot.clinicakotlin.entities

import javax.persistence.*

@Entity
@Table(name = "tb_login")
data class Login(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        @Column(unique = true)
        val email: String,
        val password: String,
        @ManyToMany
        @JoinTable(name = "tb_login_authorities",
                joinColumns = [JoinColumn(name = "id_login")],
                inverseJoinColumns = [JoinColumn(name = "id_authority")])
        val authorities: Set<Authority> = setOf()
)
