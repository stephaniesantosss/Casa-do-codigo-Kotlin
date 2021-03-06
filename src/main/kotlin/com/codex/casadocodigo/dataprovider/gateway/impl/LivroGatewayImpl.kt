package com.codex.casadocodigo.dataprovider.gateway.impl

import com.codex.casadocodigo.core.model.Livro
import com.codex.casadocodigo.core.model.dto.LivroOut
import com.codex.casadocodigo.core.translate.translateLivroToLivroOut
import com.codex.casadocodigo.dataprovider.gateway.LivroGateway
import com.codex.casadocodigo.dataprovider.repository.AutorRepository
import com.codex.casadocodigo.dataprovider.repository.CategoriaRepository
import com.codex.casadocodigo.dataprovider.repository.LivroRepository
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Component

@Component
class LivroGatewayImpl(
        val livroRepository: LivroRepository,
        val autorRepository: AutorRepository,
        val categoriaRepository: CategoriaRepository
) : LivroGateway {

    override fun salvaLivro(livro: Livro) {
        val autor = autorRepository.findById(livro.autor.id!!)
        val categoria = categoriaRepository.findById(livro.categoria.id!!)

        if (livroRepository.existsByTitulo(livro.titulo) || livroRepository.existsByIsbn(livro.isbn)) {
            throw DuplicateKeyException("Campo titulo e/ou isbn já está cadastrado em sistema, favor informar outro")
        } else if (autor.isEmpty || categoria.isEmpty) {
            throw ClassNotFoundException("idAutor e/ou idCategoria não encontrado")
        }

        livroRepository.save(livro)
    }

    override fun buscaLivros(): List<LivroOut> {
        val listLivros = livroRepository.findAll()
        return listLivros.map {
            LivroOut(
                    id = it.id!!,
                    titulo = it.titulo,
                    resumo = null,
                    sumario = null,
                    preco = null,
                    numPaginas = null,
                    isbn = null,
                    dataLancamento = null,
                    categoria = null,
                    autor = null
            )
        }
    }

    override fun buscaDetalhesLivro(id: Long): LivroOut {
        return livroRepository.findById(id).let {
            if (it.isEmpty)
                throw ClassNotFoundException("Id do livro não encontrado")

            translateLivroToLivroOut(it.get())
        }
    }
}