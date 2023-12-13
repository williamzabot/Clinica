package com.williamzabot.clinicakotlin.services

import com.williamzabot.clinicakotlin.dtos.InvoiceDTO
import com.williamzabot.clinicakotlin.dtos.toInvoice
import com.williamzabot.clinicakotlin.dtos.toInvoiceDTO
import com.williamzabot.clinicakotlin.entities.Invoice
import com.williamzabot.clinicakotlin.repositories.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class InvoiceService(
        @Autowired
        private val repository: InvoiceRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<InvoiceDTO> {
        return repository.findAll().map {
            it.toInvoiceDTO()
        }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): InvoiceDTO? {
        return repository.findById(id).getOrNull()?.toInvoiceDTO()
    }

    @Transactional
    fun save(invoice: Invoice): InvoiceDTO {
        return repository.save(invoice).toInvoiceDTO()
    }

    @Transactional
    fun update(id: Long, invoiceDTO: InvoiceDTO): Invoice {
        val invoiceToUpdate: Invoice = repository.getReferenceById(id)
        val newInvoice = invoiceDTO.toInvoice()
        newInvoice.id = invoiceToUpdate.id
        return repository.save(newInvoice)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}