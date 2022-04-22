package com.codex.casadocodigo.entrypoint.controller

import com.codex.casadocodigo.core.model.dto.EstadoIn
import com.codex.casadocodigo.core.usecase.EstadoUseCase
import com.codex.casadocodigo.entrypoint.controller.api.EstadoControllerApi
import org.springframework.web.bind.annotation.RestController

@RestController
class EstadoController(val estadoUseCase: EstadoUseCase) : EstadoControllerApi {

    override fun salvaEstado(estadoIn: EstadoIn) {
        estadoUseCase.salvaEstado(estadoIn)
    }
}