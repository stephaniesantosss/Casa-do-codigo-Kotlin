package com.codex.casadocodigo

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AutorIn(
        @field:NotBlank
        val nome: String,
        @field:NotBlank @field:Email
        val email: String,
        @field:NotBlank @field:Size(max = 400)
        val descricao: String,
        @JsonIgnore
        val instanteRegistro: LocalDateTime = LocalDateTime.now()
) {
}