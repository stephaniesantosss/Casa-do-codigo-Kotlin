package com.codex.casadocodigo.dataprovider.gateway.impl

import com.codex.casadocodigo.core.model.Categoria
import com.codex.casadocodigo.dataprovider.repository.CategoriaRepository
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.dao.DuplicateKeyException

@ExtendWith(MockitoExtension::class)
internal class CategoriaGatewayImplTest {

    @InjectMocks
    lateinit var categoriaGatewayImpl: CategoriaGatewayImpl

    private var gerador: EasyRandom = EasyRandom()

    private lateinit var categoria: Categoria

    @Mock
    lateinit var categoriaRepository: CategoriaRepository

    @BeforeEach
    fun setup() {
        categoria = gerador.nextObject(Categoria::class.java)
    }

    @Test
    fun deveSalvarCategoriaComSucesso() {
        `when`(categoriaRepository.existsByNome(categoria.nome)).thenReturn(false)
        assertDoesNotThrow { categoriaGatewayImpl.salvaCategoria(categoria) }
    }

    @Test
    fun deveLancarDuplicateKeyExceptionCasoNomeCategoriaDuplicado() {
        `when`(categoriaRepository.existsByNome(categoria.nome)).thenReturn(true)
        val exception = assertThrows<DuplicateKeyException> { categoriaGatewayImpl.salvaCategoria(categoria) }
        assert(exception.message.equals("Esta categoria já está cadastrada, favor informar outra"))
    }
}