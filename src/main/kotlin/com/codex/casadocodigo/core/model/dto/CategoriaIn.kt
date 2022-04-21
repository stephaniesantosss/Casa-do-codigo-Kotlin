package com.codex.casadocodigo.core.model.dto

import javax.validation.constraints.NotBlank

data class CategoriaIn(
        @field:NotBlank
        val nome: String
)