package com.codex.casadocodigo.core.usecase

import com.codex.casadocodigo.core.model.dto.AutorIn
import com.codex.casadocodigo.dataprovider.gateway.AutorGateway
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class AutorUseCaseTest {

    @InjectMocks
    lateinit var autorUseCase: AutorUseCase

    @Mock
    lateinit var autorGateway: AutorGateway

    lateinit var autorIn: AutorIn

    private var gerador: EasyRandom = EasyRandom()

    @BeforeEach
    fun setup() {
        autorIn = gerador.nextObject(AutorIn::class.java)
    }

    @Test
    fun deveSalvarAutorComSucesso() {
        assertDoesNotThrow { autorUseCase.salvaAutor(autorIn) }
    }
}