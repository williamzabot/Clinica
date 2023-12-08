package com.williamzabot.clinicakotlin.services

import com.williamzabot.clinicakotlin.dtos.AddressDTO
import com.williamzabot.clinicakotlin.dtos.toAddress
import com.williamzabot.clinicakotlin.dtos.toAddressDTO
import com.williamzabot.clinicakotlin.entities.Address
import com.williamzabot.clinicakotlin.repositories.AddressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class AddressService(
        @Autowired
        private val repository: AddressRepository
) {

    @Transactional(readOnly = true)
    fun findAll(): List<AddressDTO> {
        return repository.findAll().map {
            it.toAddressDTO()
        }
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): AddressDTO? {
        return repository.findById(id).getOrNull()?.toAddressDTO()
    }

    @Transactional
    fun save(address: Address): AddressDTO {
        return repository.save(address).toAddressDTO()
    }

    @Transactional
    fun update(id: Long, addressDTO: AddressDTO): Address {
        val addressToUpdate: Address = repository.getReferenceById(id)
        val newAddress = addressDTO.toAddress()
        newAddress.id = addressToUpdate.id
        return repository.save(newAddress)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

}