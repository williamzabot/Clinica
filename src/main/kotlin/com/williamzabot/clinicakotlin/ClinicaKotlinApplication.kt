package com.williamzabot.clinicakotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.williamzabot.clinicakotlin.repositories"])
class ClinicaKotlinApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<ClinicaKotlinApplication>(*args)
        }
    }
}






