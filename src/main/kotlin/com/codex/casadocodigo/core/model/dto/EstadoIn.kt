package com.codex.casadocodigo.core.model.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class EstadoIn(
        @field:NotBlank
        val nome: String,
        @field:NotNull
        val idPais: Long
)
