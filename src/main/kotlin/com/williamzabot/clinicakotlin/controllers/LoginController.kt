package com.williamzabot.clinicakotlin.controllers

import com.williamzabot.clinicakotlin.dtos.LoginDTO
import com.williamzabot.clinicakotlin.dtos.toLogin
import com.williamzabot.clinicakotlin.dtos.toLoginDTO
import com.williamzabot.clinicakotlin.services.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("v1/login")
class LoginController(
        @Autowired
        val service: LoginService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<LoginDTO>> {
        return ResponseEntity.ok().body(service.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<LoginDTO?> {
        val loginDTO: LoginDTO? = service.findById(id)
        return if (loginDTO != null) {
            ResponseEntity.ok().body(loginDTO)
        } else {
            ResponseEntity.status(404).body(null)
        }
    }

    @PostMapping
    fun save(@RequestBody loginDTO: LoginDTO): ResponseEntity<LoginDTO> {
        val created = service.save(loginDTO.toLogin())
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(created.id).toUri()
        return ResponseEntity.created(uri).body(created)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,
               @RequestBody loginDTO: LoginDTO
    ): ResponseEntity<LoginDTO> {
        val authority = service.update(id, loginDTO).toLoginDTO()
        return ResponseEntity.ok().body(authority)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}