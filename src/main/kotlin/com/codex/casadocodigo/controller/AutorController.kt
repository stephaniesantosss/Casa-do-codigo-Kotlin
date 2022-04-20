package com.codex.casadocodigo.controller

import com.codex.casadocodigo.AutorIn
import com.codex.casadocodigo.controller.api.AutorControllerApi
import com.codex.casadocodigo.usecase.AutorUseCase
import org.springframework.web.bind.annotation.RestController

@RestController
class AutorController(val autorUseCase: AutorUseCase) : AutorControllerApi {

    override fun salvaAutor(autorIn: AutorIn) {
        autorUseCase.salvaAutor(autorIn)
    }


}