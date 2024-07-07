package com.williamzabot.clinicakotlin.services

import com.williamzabot.clinicakotlin.dtos.AddressDTO
import com.williamzabot.clinicakotlin.dtos.toAddressDTO
import com.williamzabot.clinicakotlin.entities.Address
import com.williamzabot.clinicakotlin.repositories.AddressRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class AddressServiceTest {

    private lateinit var service: AddressService
    private lateinit var repository: AddressRepository

    @BeforeEach
    fun setUp() {
        repository = mockk()
        service = AddressService(repository)
    }

    @Test
    fun testFindAll() {
        // Dados de exemplo
        val addresses = listOf(
            Address(
                1L, "Rua A",
                number = null,
                complement = null,
                neighborhood = null,
                zipCode = null,
                city = null,
                state = null
            ),
            Address(
                2L, "Rua B",
                number = null,
                complement = null,
                neighborhood = null,
                zipCode = null,
                city = null,
                state = null,
            )
        )
        val addressDTOs = addresses.map { it.toAddressDTO() }

        // Configurando o mock do método findAll() do repositório
        every { repository.findAll() } returns addresses

        // Chamando o método do serviço que depende do findAll() do repositório
        val result = service.findAll()

        // Verificando se o método do serviço retorna o resultado esperado
        assertEquals(addressDTOs.size, result.size)
        assertEquals(addressDTOs[0].street, result[0].street)
        assertEquals(addressDTOs[1].street, result[1].street)
    }

    @Test
    fun testFindById() {
        // Dados de exemplo
        val id = 1L
        val address = Address(
            1L, "Rua A",
            number = null,
            complement = null,
            neighborhood = null,
            zipCode = null,
            city = null,
            state = null
        )
        val addressDTO = address.toAddressDTO()

        // Configurando o mock do método findById() do repositório
        every { repository.findById(id) } returns Optional.of(address)

        // Chamando o método do serviço que depende do findById() do repositório
        val result = service.findById(id)

        // Verificando se o método do serviço retorna o resultado esperado
        assertEquals(addressDTO.street, result?.street)
    }

    @Test
    fun testSave() {
        // Dados de exemplo
        val addressToSave = Address(
            1L, "Rua C",
            number = null,
            complement = null,
            neighborhood = null,
            zipCode = null,
            city = null,
            state = null
        )
        val savedAddress = Address(
            1L, "Rua C",
            number = null,
            complement = null,
            neighborhood = null,
            zipCode = null,
            city = null,
            state = null
        )
        val addressDTO = savedAddress.toAddressDTO()

        // Configurando o mock do método save() do repositório
        every { repository.save(addressToSave) } returns savedAddress

        // Chamando o método do serviço que depende do save() do repositório
        val result = service.save(addressToSave)

        // Verificando se o método do serviço retorna o resultado esperado
        assertEquals(addressDTO.street, result.street)
    }

    @Test
    fun testUpdate() {
        // Dados de exemplo
        val id = 1L
        val addressToUpdate = Address(
            1L, "Rua C",
            number = null,
            complement = null,
            neighborhood = null,
            zipCode = null,
            city = null,
            state = null
        )
        val updatedAddressDTO = AddressDTO(
            id, "Rua B",
            number = null,
            complement = null,
            neighborhood = null,
            zipCode = null,
            city = null,
            state = null
        )

        // Configurando o mock do método getReferenceById() do repositório
        every { repository.getReferenceById(id) } returns addressToUpdate

        // Configurando o mock do método save() do repositório
        every { repository.save(any()) } answers { firstArg() }

        // Chamando o método do serviço que depende do update() do repositório
        val result = service.update(id, updatedAddressDTO)

        // Verificando se o método do serviço retorna o resultado esperado
        assertEquals(id, result.id)
        assertEquals(updatedAddressDTO.street, result.street)
    }
}
