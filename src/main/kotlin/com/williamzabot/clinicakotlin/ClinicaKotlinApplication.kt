package com.williamzabot.clinicakotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ClinicaKotlinApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<ClinicaKotlinApplication>(*args)
        }
    }
}






