package com.codex.casadocodigo.core.usecase

import com.codex.casadocodigo.core.model.dto.LivroIn
import com.codex.casadocodigo.core.translate.translateLivroInToLivro
import com.codex.casadocodigo.dataprovider.gateway.LivroGateway
import org.springframework.stereotype.Component

@Component
class LivroUseCase(val livroGateway: LivroGateway) {

    fun salvaLivro(livroIn: LivroIn) {
        val livro = translateLivroInToLivro(livroIn)
        livroGateway.salvaLivro(livro)
    }
}