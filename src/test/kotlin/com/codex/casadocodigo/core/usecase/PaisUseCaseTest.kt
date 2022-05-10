package com.codex.casadocodigo.core.usecase

import com.codex.casadocodigo.core.model.dto.PaisIn
import com.codex.casadocodigo.dataprovider.gateway.PaisGateway
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class PaisUseCaseTest {

    @InjectMocks
    lateinit var paisUseCase: PaisUseCase

    @Mock
    lateinit var paisGateway: PaisGateway

    lateinit var paisIn: PaisIn

    var gerador: EasyRandom = EasyRandom()

    @BeforeEach
    fun setUp() {
        paisIn = gerador.nextObject(PaisIn::class.java)
    }

    @Test
    fun deveSalvarPaisComSucesso() {
        assertDoesNotThrow { paisUseCase.salvaPais(paisIn) }
    }
}