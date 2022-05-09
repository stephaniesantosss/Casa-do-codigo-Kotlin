package com.codex.casadocodigo.entrypoint.controller

import com.codex.casadocodigo.core.model.dto.EstadoIn
import com.codex.casadocodigo.core.usecase.EstadoUseCase
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class EstadoControllerTest {

    @InjectMocks
    lateinit var estadoController: EstadoController

    @Mock
    val estadoUseCase: EstadoUseCase = mock(EstadoUseCase::class.java)

    private var gerador: EasyRandom = EasyRandom()

    private lateinit var estadoIn: EstadoIn

    @BeforeEach
    fun setup() {
        estadoIn = gerador.nextObject(EstadoIn::class.java)
    }

    @Test
    fun deveSalvarEstadoComSucesso() {
        assertDoesNotThrow { estadoController.salvaEstado(estadoIn) }
    }
}