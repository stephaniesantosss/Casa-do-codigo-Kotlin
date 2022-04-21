package com.codex.casadocodigo.core.usecase.controller.api

import com.codex.casadocodigo.core.model.dto.AutorIn
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

@RequestMapping("/autor")
interface AutorControllerApi {

    @ResponseStatus(OK)
    @PostMapping
    fun salvaAutor(@Valid @RequestBody autorIn: AutorIn)
}