package com.codex.casadocodigo.core.translate

import com.codex.casadocodigo.core.model.Autor
import com.codex.casadocodigo.core.model.Categoria
import com.codex.casadocodigo.core.model.Livro
import com.codex.casadocodigo.core.model.dto.LivroIn
import com.codex.casadocodigo.core.model.dto.LivroOut

fun translateLivroInToLivro(livroIn: LivroIn): Livro {
    return Livro(
            id = null,
            titulo = livroIn.titulo,
            resumo = livroIn.resumo,
            sumario = livroIn.sumario,
            preco = livroIn.preco,
            numPaginas = livroIn.numPaginas,
            isbn = livroIn.isbn,
            dataLancamento = livroIn.dataLancamento,
            categoria = Categoria(id = livroIn.idCategoria, ""),
            autor = Autor(livroIn.idAutor, "", "", "")
    )
}

fun translateLivroToLivroOut(livro: Livro): LivroOut {
    return LivroOut(
            id = livro.id!!,
            titulo = livro.titulo,
            resumo = livro.resumo,
            sumario = livro.sumario,
            preco = livro.preco,
            numPaginas = livro.numPaginas,
            isbn = livro.isbn,
            dataLancamento = livro.dataLancamento,
            categoria = livro.categoria,
            autor = livro.autor
    )
}