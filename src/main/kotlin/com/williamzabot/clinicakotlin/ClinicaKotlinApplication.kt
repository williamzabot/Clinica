package com.williamzabot.clinicakotlin

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.williamzabot.clinicakotlin.repositories"])
class ClinicaKotlinApplication {

    companion object {
        val LOG = LoggerFactory.getLogger(ClinicaKotlinApplication::class.java)
        @JvmStatic
        fun main(args: Array<String>) {

            runApplication<ClinicaKotlinApplication>(*args)
            SpringApplication.run(ClinicaKotlinApplication::class.java, *args).use {
                context -> LOG.trace("context: $context")
            }
        }

    }
}






