package com.codex.casadocodigo.entrypoint.controller

import com.codex.casadocodigo.core.model.dto.CategoriaIn
import com.codex.casadocodigo.core.usecase.CategoriaUseCase
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class CategoriaControllerTest {

    @InjectMocks
    lateinit var categoriaController: CategoriaController

    @Mock
    val categoriaUseCase: CategoriaUseCase = mock(CategoriaUseCase::class.java)

    private var gerador: EasyRandom = EasyRandom()

    private lateinit var categoriaIn: CategoriaIn

    @BeforeEach
    fun setup() {
        categoriaIn = gerador.nextObject(CategoriaIn::class.java)
    }

    @Test
    fun deveSalvarCategoriaComSucesso() {
        assertDoesNotThrow { categoriaController.salvaCategoria(categoriaIn) }
    }
}