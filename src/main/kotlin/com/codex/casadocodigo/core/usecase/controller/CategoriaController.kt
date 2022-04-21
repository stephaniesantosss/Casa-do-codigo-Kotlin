package com.codex.casadocodigo.core.usecase.controller

import com.codex.casadocodigo.core.model.dto.CategoriaIn
import com.codex.casadocodigo.core.usecase.CategoriaUseCase
import com.codex.casadocodigo.core.usecase.controller.api.CategoriaControllerApi
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoriaController(val categoriaUseCase: CategoriaUseCase) : CategoriaControllerApi {

    override fun salvaCategoria(categoriaIn: CategoriaIn) {
        categoriaUseCase.salvaCategoria(categoriaIn)
    }
}