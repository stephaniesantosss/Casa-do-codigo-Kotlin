package com.codex.casadocodigo.dataprovider.gateway.impl

import com.codex.casadocodigo.core.model.Estado
import com.codex.casadocodigo.core.model.Pais
import com.codex.casadocodigo.dataprovider.repository.EstadoRepository
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
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class EstadoGatewayImplTest {

    @InjectMocks
    lateinit var estadoGatewayImpl: EstadoGatewayImpl

    @Mock
    lateinit var paisRepository: PaisRepository

    @Mock
    lateinit var estadoRepository: EstadoRepository

    lateinit var pais: Pais

    private var gerador: EasyRandom = EasyRandom()

    lateinit var estado: Estado

    @BeforeEach
    fun setup() {
        estado = gerador.nextObject(Estado::class.java)
        pais = gerador.nextObject(Pais::class.java)
    }

    @Test
    fun deveSalvarEstadoComSucesso() {
        `when`(paisRepository.findById(estado.pais.id!!)).thenReturn(Optional.of(estado.pais))
        `when`(estadoRepository.existsByNome(estado.nome)).thenReturn(false)
        assertDoesNotThrow { estadoGatewayImpl.salvaEstado(estado) }
    }

    @Test
    fun deveLancarClassNotFoundExceptionCasoPaisNaoEncontrado() {
        `when`(paisRepository.findById(estado.pais.id!!)).thenReturn(Optional.empty())
        val exception = assertThrows<ClassNotFoundException> { estadoGatewayImpl.salvaEstado(estado) }
        assert(exception.message.equals("IdPais não foi encontrado, favor informar outro"))
    }

    @Test
    fun deveLancarDuplicateKeyExceptionSePaisJaCadastrado() {
        `when`(paisRepository.findById(estado.pais.id!!)).thenReturn(Optional.of(estado.pais))
        `when`(estadoRepository.existsByNome(estado.nome)).thenReturn(true)
        val exception = assertThrows<DuplicateKeyException> { estadoGatewayImpl.salvaEstado(estado) }
        assert(exception.message.equals("Este pais já está cadastrado, favor informar outro"))
    }
}