package com.codex.casadocodigo.core.model.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import javax.validation.constraints.*

data class LivroIn(
        @field:NotBlank
        val titulo: String,
        @field:NotBlank @field:Size(max = 500)
        val resumo: String,
        val sumario: String,
        @field:NotNull @field:DecimalMin("20.00")
        val preco: Double,
        @field:NotNull @field:Min(100)
        val numPaginas: Int,
        @field:NotBlank
        val isbn: String,
        @field:Future @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val dataLancamento: LocalDate,
        @field:NotNull
        val idCategoria: Long,
        @field:NotNull
        val idAutor: Long
)