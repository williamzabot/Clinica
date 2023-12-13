package com.williamzabot.clinicakotlin.controllers

import com.williamzabot.clinicakotlin.dtos.InvoiceDTO
import com.williamzabot.clinicakotlin.dtos.toInvoice
import com.williamzabot.clinicakotlin.dtos.toInvoiceDTO
import com.williamzabot.clinicakotlin.services.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("v1/faturas")
class InvoiceController(
        @Autowired
        val service: InvoiceService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<InvoiceDTO>> {
        return ResponseEntity.ok().body(service.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<InvoiceDTO?> {
        val invoiceDTO: InvoiceDTO? = service.findById(id)
        return if (invoiceDTO != null) {
            ResponseEntity.ok().body(invoiceDTO)
        } else {
            ResponseEntity.status(404).body(null)
        }
    }

    @PostMapping
    fun save(@RequestBody invoiceDTO: InvoiceDTO): ResponseEntity<InvoiceDTO> {
        val created = service.save(invoiceDTO.toInvoice())
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(created.id).toUri()
        return ResponseEntity.created(uri).body(created)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,
               @RequestBody invoiceDTO: InvoiceDTO
    ): ResponseEntity<InvoiceDTO> {
        val employee = service.update(id, invoiceDTO).toInvoiceDTO()
        return ResponseEntity.ok().body(employee)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

}