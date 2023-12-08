package com.williamzabot.clinicakotlin.repositories

import com.williamzabot.clinicakotlin.entities.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long>