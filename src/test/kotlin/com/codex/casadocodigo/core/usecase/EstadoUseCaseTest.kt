package com.codex.casadocodigo.core.usecase

import com.codex.casadocodigo.core.model.dto.EstadoIn
import com.codex.casadocodigo.dataprovider.gateway.EstadoGateway
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class EstadoUseCaseTest {

    @InjectMocks
    lateinit var estadoUseCase: EstadoUseCase

    @Mock
    lateinit var estadoGateway: EstadoGateway

    lateinit var estadoIn: EstadoIn

    var gerador: EasyRandom = EasyRandom()

    @BeforeEach
    fun setUp() {
        estadoIn = gerador.nextObject(EstadoIn::class.java)
    }

    @Test
    fun deveSalvarEstadoComSucesso() {
        assertDoesNotThrow { estadoUseCase.salvaEstado(estadoIn) }
    }
}