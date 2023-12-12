package com.williamzabot.clinicakotlin.controllers

import com.williamzabot.clinicakotlin.dtos.AuthorityDTO
import com.williamzabot.clinicakotlin.dtos.toAuthority
import com.williamzabot.clinicakotlin.dtos.toAuthorityDTO
import com.williamzabot.clinicakotlin.services.AuthorityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("v1/authorities")
class AuthorityController(
        @Autowired
        val service: AuthorityService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<AuthorityDTO>> {
        return ResponseEntity.ok().body(service.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<AuthorityDTO?> {
        val authorityDTO: AuthorityDTO? = service.findById(id)
        return if (authorityDTO != null) {
            ResponseEntity.ok().body(authorityDTO)
        } else {
            ResponseEntity.status(404).body(null)
        }
    }

    @PostMapping
    fun save(@RequestBody authorityDTO: AuthorityDTO): ResponseEntity<AuthorityDTO> {
        val created = service.save(authorityDTO.toAuthority())
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(created.id).toUri()
        return ResponseEntity.created(uri).body(created)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,
               @RequestBody authorityDTO: AuthorityDTO
    ): ResponseEntity<AuthorityDTO> {
        val authority = service.update(id, authorityDTO).toAuthorityDTO()
        return ResponseEntity.ok().body(authority)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}