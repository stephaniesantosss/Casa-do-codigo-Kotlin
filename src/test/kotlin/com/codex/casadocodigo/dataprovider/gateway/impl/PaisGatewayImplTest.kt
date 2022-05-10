package com.codex.casadocodigo.dataprovider.gateway.impl

import com.codex.casadocodigo.core.model.Pais
import com.codex.casadocodigo.dataprovider.repository.PaisRepository
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
internal class PaisGatewayImplTest {

    @InjectMocks
    lateinit var paisGatewayImpl: PaisGatewayImpl

    private var gerador: EasyRandom = EasyRandom()

    lateinit var pais: Pais

    @Mock
    lateinit var paisRepository: PaisRepository

    @BeforeEach
    fun setup() {
        pais = gerador.nextObject(Pais::class.java)
    }

    @Test
    fun deveSalvarPaisComSucesso() {
        `when`(paisRepository.existsByNome(pais.nome!!)).thenReturn(false)
        assertDoesNotThrow { paisGatewayImpl.salvaPais(pais) }
    }

    @Test
    fun deveLancarDuplicateKeyExceptionCasoPaisJaCadastrado() {
        `when`(paisRepository.existsByNome(pais.nome!!)).thenReturn(true)
        val exception = assertThrows<DuplicateKeyException> { paisGatewayImpl.salvaPais(pais) }
        assert(exception.message.equals("Este Pais já está cadastrado, favor informar outro"))
    }
}