package com.codex.casadocodigo.core.model.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AutorIn(
        @field:NotBlank
        val nome: String,
        @field:NotBlank @field:Email(message = "E-mail inválido")
        val email: String,
        @field:NotBlank @field:Size(max = 400)
        val descricao: String,
        @JsonIgnore
        val instanteRegistro: LocalDateTime = LocalDateTime.now()
)