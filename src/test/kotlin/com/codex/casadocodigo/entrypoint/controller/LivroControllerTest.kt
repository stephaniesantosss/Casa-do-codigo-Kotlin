package com.codex.casadocodigo.entrypoint.controller

import com.codex.casadocodigo.core.model.dto.LivroIn
import com.codex.casadocodigo.core.model.dto.LivroOut
import com.codex.casadocodigo.core.usecase.LivroUseCase
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.util.stream.Collectors

@ExtendWith(MockitoExtension::class)
internal class LivroControllerTest {

    @InjectMocks
    lateinit var livroController: LivroController

    @Mock
    private lateinit var livroUseCase: LivroUseCase

    private lateinit var livroIn: LivroIn

    private lateinit var livroOut: LivroOut

    private var gerador: EasyRandom = EasyRandom()

    private lateinit var listLivro: List<LivroOut>

    @BeforeEach
    fun setup() {
        livroIn = gerador.nextObject(LivroIn::class.java)
        listLivro = gerador.objects(LivroOut::class.java, 2).collect(Collectors.toList())
        livroOut = gerador.nextObject(LivroOut::class.java)
    }

    @Test
    fun deveSalvarLivroComSucesso() {
        assertDoesNotThrow { livroController.salvaLivro(livroIn) }
    }

    @Test
    fun deveBuscarLivrosComSucesso() {
        `when`(livroUseCase.buscaLivros()).thenReturn(listLivro)
        val response = livroController.buscaLivros()
        assertEquals(listLivro, response)
        assertNotNull(response)
        assertDoesNotThrow { livroController.buscaLivros() }
    }

    @Test
    fun deveBuscarDetalhesDeLivroComSucesso() {
        val ID_LIVRO = 1L
        `when`(livroUseCase.buscaDetalhesLivro(ID_LIVRO)).thenReturn(livroOut)
        val response = livroController.buscaDetalhesLivro(ID_LIVRO)
        assertNotNull(response)
        assertDoesNotThrow { livroController.buscaDetalhesLivro(ID_LIVRO) }
    }
}