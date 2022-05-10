package com.codex.casadocodigo.dataprovider.gateway.impl

import com.codex.casadocodigo.core.model.Autor
import com.codex.casadocodigo.core.model.Categoria
import com.codex.casadocodigo.core.model.Livro
import com.codex.casadocodigo.core.model.dto.LivroOut
import com.codex.casadocodigo.dataprovider.repository.AutorRepository
import com.codex.casadocodigo.dataprovider.repository.CategoriaRepository
import com.codex.casadocodigo.dataprovider.repository.LivroRepository
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
import java.util.*
import java.util.stream.Collectors

@ExtendWith(MockitoExtension::class)
internal class LivroGatewayImplTest {

    @InjectMocks
    lateinit var livroGatewayImpl: LivroGatewayImpl

    private var gerador: EasyRandom = EasyRandom()

    lateinit var livro: Livro

    lateinit var autor: Autor

    lateinit var categoria: Categoria

    lateinit var listLivro: List<Livro>

    lateinit var livroOut: LivroOut

    @Mock
    lateinit var autorRepository: AutorRepository

    @Mock
    lateinit var categoriaRepository: CategoriaRepository

    @Mock
    lateinit var livroRepository: LivroRepository

    @BeforeEach
    fun setup() {
        livro = gerador.nextObject(Livro::class.java)
        autor = gerador.nextObject(Autor::class.java)
        categoria = gerador.nextObject(Categoria::class.java)
        listLivro = gerador.objects(Livro::class.java, 3).collect(Collectors.toList())
        livroOut = gerador.nextObject(LivroOut::class.java)
    }

    @Test
    fun deveSalvarLivroComSucesso() {
        `when`(autorRepository.findById(livro.autor.id!!)).thenReturn(Optional.of(autor))
        `when`(categoriaRepository.findById(livro.categoria.id!!)).thenReturn(Optional.of(categoria))
        `when`(livroRepository.existsByTitulo(livro.titulo)).thenReturn(false)
        `when`(livroRepository.existsByIsbn(livro.isbn)).thenReturn(false)
        assertDoesNotThrow { livroGatewayImpl.salvaLivro(livro) }
    }

    @Test
    fun deveLancarDuplicateKeyExceptionCasoTituloDuplicado() {
        `when`(autorRepository.findById(livro.autor.id!!)).thenReturn(Optional.of(autor))
        `when`(categoriaRepository.findById(livro.categoria.id!!)).thenReturn(Optional.of(categoria))
        `when`(livroRepository.existsByTitulo(livro.titulo)).thenReturn(true)
        val exception = assertThrows<DuplicateKeyException> { livroGatewayImpl.salvaLivro(livro) }
        assert(exception.message.equals("Campo titulo e/ou isbn já está cadastrado em sistema, favor informar outro"))
    }

    @Test
    fun deveLancarDuplicateKeyExceptionCasoISBNDuplicado() {
        `when`(autorRepository.findById(livro.autor.id!!)).thenReturn(Optional.of(autor))
        `when`(categoriaRepository.findById(livro.categoria.id!!)).thenReturn(Optional.of(categoria))
        `when`(livroRepository.existsByTitulo(livro.titulo)).thenReturn(false)
        `when`(livroRepository.existsByIsbn(livro.isbn)).thenReturn(true)
        val exception = assertThrows<DuplicateKeyException> { livroGatewayImpl.salvaLivro(livro) }
        assert(exception.message.equals("Campo titulo e/ou isbn já está cadastrado em sistema, favor informar outro"))
    }

    @Test
    fun deveLancarClassNotFoundExceptionCasoAutorNaoExista() {
        `when`(autorRepository.findById(livro.autor.id!!)).thenReturn(Optional.empty())
        `when`(categoriaRepository.findById(livro.categoria.id!!)).thenReturn(Optional.of(categoria))
        `when`(livroRepository.existsByTitulo(livro.titulo)).thenReturn(false)
        `when`(livroRepository.existsByIsbn(livro.isbn)).thenReturn(false)
        val exception = assertThrows<ClassNotFoundException> { livroGatewayImpl.salvaLivro(livro) }
        assert(exception.message.equals("idAutor e/ou idCategoria não encontrado"))
    }

    @Test
    fun deveLancarClassNotFoundExceptionCasoCategoriaNaoExista() {
        `when`(autorRepository.findById(livro.autor.id!!)).thenReturn(Optional.of(autor))
        `when`(categoriaRepository.findById(livro.categoria.id!!)).thenReturn(Optional.empty())
        `when`(livroRepository.existsByTitulo(livro.titulo)).thenReturn(false)
        `when`(livroRepository.existsByIsbn(livro.isbn)).thenReturn(false)
        val exception = assertThrows<ClassNotFoundException> { livroGatewayImpl.salvaLivro(livro) }
        assert(exception.message.equals("idAutor e/ou idCategoria não encontrado"))
    }

    @Test
    fun deveBuscarLivrosComSucesso() {
        `when`(livroRepository.findAll()).thenReturn(listLivro)
        val resposta = assertDoesNotThrow { livroGatewayImpl.buscaLivros() }
        assert(resposta.isNotEmpty())
    }

    @Test
    fun deveBuscarDetalhesLivroComSucesso() {
        `when`(livroRepository.findById(livro.id!!)).thenReturn(Optional.of(livro))
        val resposta = assertDoesNotThrow { livroGatewayImpl.buscaDetalhesLivro(livro.id!!) }
        assert(!resposta.equals(null))
    }

    @Test
    fun deveLancarClassNotFoundExceptionCasoIdLivroNaoEncontrado() {
        `when`(livroRepository.findById(livro.id!!)).thenReturn(Optional.empty())
        val exception = assertThrows<ClassNotFoundException> { livroGatewayImpl.buscaDetalhesLivro(livro.id!!) }
        assert(exception.message.equals("Id do livro não encontrado"))
    }
}