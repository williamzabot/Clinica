package com.williamzabot.clinicakotlin.controllers

import com.williamzabot.clinicakotlin.dtos.*
import com.williamzabot.clinicakotlin.services.AddressService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("v1/addresses")
class AddressController(
        @Autowired
        val service: AddressService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<AddressDTO>> {
        return ResponseEntity.ok().body(service.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<AddressDTO?> {
        val addressDTO: AddressDTO? = service.findById(id)
        return if (addressDTO != null) {
            ResponseEntity.ok().body(addressDTO)
        } else {
            ResponseEntity.status(404).body(null)
        }
    }

    @PostMapping
    fun save(@RequestBody addressDTO: AddressDTO): ResponseEntity<AddressDTO> {
        val created = service.save(addressDTO.toAddress())
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(created.id).toUri()
        return ResponseEntity.created(uri).body(created)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,
               @RequestBody addressDTO: AddressDTO
    ): ResponseEntity<AddressDTO> {
        val address = service.update(id, addressDTO).toAddressDTO()
        return ResponseEntity.ok().body(address)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}