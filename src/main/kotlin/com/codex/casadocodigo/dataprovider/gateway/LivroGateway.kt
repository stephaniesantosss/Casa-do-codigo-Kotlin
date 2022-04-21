package com.codex.casadocodigo.dataprovider.gateway

import com.codex.casadocodigo.core.model.Livro

interface LivroGateway {

    fun salvaLivro(livro: Livro)

}