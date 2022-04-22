package com.codex.casadocodigo.dataprovider.gateway

import com.codex.casadocodigo.core.model.Livro
import com.codex.casadocodigo.core.model.dto.LivroOut

interface LivroGateway {

    fun salvaLivro(livro: Livro)

    fun buscaLivros(): List<LivroOut>

}