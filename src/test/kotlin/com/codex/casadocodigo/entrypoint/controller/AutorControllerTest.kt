package com.codex.casadocodigo.entrypoint.controller

import com.codex.casadocodigo.core.model.dto.AutorIn
import com.codex.casadocodigo.core.usecase.AutorUseCase
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime

@ExtendWith(MockitoExtension::class)
internal class AutorControllerTest {

    @InjectMocks
    lateinit var autorController: AutorController

    @Mock
    val autorUseCase: AutorUseCase = mock(AutorUseCase::class.java)

    private lateinit var autorIn: AutorIn

    @BeforeEach
    fun setup() {
        autorIn = autorIn()
    }

    @Test
    fun deveSalvarAutorComSucesso() {
        assertDoesNotThrow { autorController.salvaAutor(autorIn) }
    }

    fun autorIn(): AutorIn {
        return AutorIn(
                nome = "Stephanie",
                email = "stephanie@gmail.com",
                descricao = "aaaaaaa",
                instanteRegistro = LocalDateTime.now()
        )
    }
}