package com.codex.casadocodigo.dataprovider.gateway.impl

import com.codex.casadocodigo.core.model.Autor
import com.codex.casadocodigo.dataprovider.repository.AutorRepository
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.dao.DuplicateKeyException

@ExtendWith(MockitoExtension::class)
internal class AutorGatewayImplTest {

    @InjectMocks
    lateinit var autorGatewayImpl: AutorGatewayImpl

    @Mock
    lateinit var autorRepository: AutorRepository

    private var gerador: EasyRandom = EasyRandom()

    private lateinit var autor: Autor

    @BeforeEach
    fun setup() {
        autor = gerador.nextObject(Autor::class.java)
    }

    @Test
    fun deveSalvarAutorComSucesso() {
        assertDoesNotThrow { autorGatewayImpl.salvaAutor(autor) }
    }

    @Test
    fun deveLancarDuplicateKeyExceptionCasoEmailSejaDuplicado() {
        `when`(autorRepository.existsByEmail(autor.email)).thenReturn(true)
        val exception = assertThrows<DuplicateKeyException> { autorGatewayImpl.salvaAutor(autor) }
        assert(exception.message.equals("Este email já está cadastrado, favor informar outro"))
    }
}