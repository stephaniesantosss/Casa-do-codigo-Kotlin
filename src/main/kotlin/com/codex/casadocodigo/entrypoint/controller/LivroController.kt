package com.codex.casadocodigo.entrypoint.controller

import com.codex.casadocodigo.core.model.dto.LivroIn
import com.codex.casadocodigo.core.model.dto.LivroOut
import com.codex.casadocodigo.core.usecase.LivroUseCase
import com.codex.casadocodigo.entrypoint.controller.api.LivroControllerApi
import org.springframework.web.bind.annotation.RestController

@RestController
class LivroController(val livroUseCase: LivroUseCase) : LivroControllerApi {

    override fun salvaLivro(livroIn: LivroIn) {
        livroUseCase.salvaLivro(livroIn)
    }

    override fun buscaLivros(): List<LivroOut> {
        return livroUseCase.buscaLivros()
    }

    override fun buscaDetalhesLivro(id: Long): LivroOut {
        return livroUseCase.buscaDetalhesLivro(id)
    }
}