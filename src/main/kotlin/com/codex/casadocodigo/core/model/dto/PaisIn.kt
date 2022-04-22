package com.codex.casadocodigo.core.model.dto

import javax.validation.constraints.NotBlank

data class PaisIn(
        @field:NotBlank
        val nome: String
)
