package com.codex.casadocodigo.core.usecase

import com.codex.casadocodigo.core.model.dto.CategoriaIn
import com.codex.casadocodigo.dataprovider.gateway.CategoriaGateway
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class CategoriaUseCaseTest {

    @InjectMocks
    lateinit var categoriaUseCase: CategoriaUseCase

    @Mock
    lateinit var categoriaGateway: CategoriaGateway

    lateinit var categoriaIn: CategoriaIn

    var gerador: EasyRandom = EasyRandom()

    @BeforeEach
    fun setUp() {
        categoriaIn = gerador.nextObject(CategoriaIn::class.java)
    }

    @Test
    fun deveSalvarCategoriaComSucesso() {
        assertDoesNotThrow { categoriaUseCase.salvaCategoria(categoriaIn) }
    }
}