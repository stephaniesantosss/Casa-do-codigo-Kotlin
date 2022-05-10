package com.codex.casadocodigo.core.usecase

import com.codex.casadocodigo.core.model.dto.LivroIn
import com.codex.casadocodigo.core.model.dto.LivroOut
import com.codex.casadocodigo.dataprovider.gateway.LivroGateway
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.util.stream.Collectors

@ExtendWith(MockitoExtension::class)
internal class LivroUseCaseTest {

    @InjectMocks
    lateinit var livroUseCase: LivroUseCase

    @Mock
    lateinit var livroGateway: LivroGateway

    lateinit var livroIn: LivroIn

    lateinit var listLivroOut: List<LivroOut>

    lateinit var livroOut: LivroOut

    var gerador: EasyRandom = EasyRandom()

    @BeforeEach
    fun setUp() {
        livroIn = gerador.nextObject(LivroIn::class.java)
        listLivroOut = gerador.objects(LivroOut::class.java, 2).collect(Collectors.toList())
        livroOut = gerador.nextObject(LivroOut::class.java)
    }

    @Test
    fun deveSalvarLivroComSucesso() {
        assertDoesNotThrow { livroUseCase.salvaLivro(livroIn) }
    }

    @Test
    fun deveBuscarLivrosComSucesso() {
        `when`(livroGateway.buscaLivros()).thenReturn(listLivroOut)
        val resposta = assertDoesNotThrow { livroUseCase.buscaLivros() }
        assert(!resposta.equals(null))
    }

    @Test
    fun deveBuscarDetalhesLivroComSucesso() {
        val ID_LIVRO = 1L
        `when`(livroGateway.buscaDetalhesLivro(ID_LIVRO)).thenReturn(livroOut)
        val resposta = assertDoesNotThrow { livroUseCase.buscaDetalhesLivro(ID_LIVRO) }
        assert(!resposta.equals(null))
    }
}