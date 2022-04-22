package com.codex.casadocodigo.entrypoint.controller

import com.codex.casadocodigo.core.model.dto.PaisIn
import com.codex.casadocodigo.core.usecase.PaisUseCase
import com.codex.casadocodigo.entrypoint.controller.api.PaisControllerApi
import org.springframework.web.bind.annotation.RestController

@RestController
class PaisController(val paisUseCase: PaisUseCase) : PaisControllerApi {

    override fun salvaPais(paisIn: PaisIn) {
        paisUseCase.salvaPais(paisIn)
    }
}