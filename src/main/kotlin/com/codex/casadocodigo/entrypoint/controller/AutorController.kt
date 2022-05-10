package com.codex.casadocodigo.entrypoint.controller

import com.codex.casadocodigo.core.model.dto.AutorIn
import com.codex.casadocodigo.core.usecase.AutorUseCase
import com.codex.casadocodigo.entrypoint.controller.api.AutorControllerApi
import org.springframework.web.bind.annotation.RestController

@RestController
class AutorController(val autorUseCase: AutorUseCase) : AutorControllerApi {

    override fun salvaAutor(autorIn: AutorIn) {
        autorUseCase.salvaAutor(autorIn)
    }
}