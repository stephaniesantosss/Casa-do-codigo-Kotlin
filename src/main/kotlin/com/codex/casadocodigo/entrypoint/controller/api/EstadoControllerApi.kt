package com.codex.casadocodigo.entrypoint.controller.api

import com.codex.casadocodigo.core.model.dto.EstadoIn
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

@RequestMapping("/estado")
interface EstadoControllerApi {

    @ResponseStatus(OK)
    @PostMapping
    fun salvaEstado(@Valid @RequestBody estadoIn: EstadoIn)
}