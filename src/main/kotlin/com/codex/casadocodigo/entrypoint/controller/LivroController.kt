package com.codex.casadocodigo.entrypoint.controller

import com.codex.casadocodigo.core.model.dto.LivroIn
import com.codex.casadocodigo.core.usecase.LivroUseCase
import com.codex.casadocodigo.entrypoint.controller.api.LivroControllerApi
import org.springframework.web.bind.annotation.RestController

@RestController
class LivroController(val livroUseCase: LivroUseCase) : LivroControllerApi {

    override fun salvaLivro(livroIn: LivroIn) {
        livroUseCase.salvaLivro(livroIn)
    }
}