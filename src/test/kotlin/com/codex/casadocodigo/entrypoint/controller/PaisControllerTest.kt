package com.codex.casadocodigo.entrypoint.controller

import com.codex.casadocodigo.core.model.dto.PaisIn
import com.codex.casadocodigo.core.usecase.PaisUseCase
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class PaisControllerTest {

    @InjectMocks
    lateinit var paisController: PaisController

    @Mock
    lateinit var paisUseCase: PaisUseCase

    private var gerador: EasyRandom = EasyRandom()

    lateinit var paisIn: PaisIn

    @BeforeEach
    fun setup() {
        paisIn = gerador.nextObject(PaisIn::class.java)
    }

    @Test
    fun deveSalvarPaisComSucesso() {
        assertDoesNotThrow { paisController.salvaPais(paisIn) }
    }
}