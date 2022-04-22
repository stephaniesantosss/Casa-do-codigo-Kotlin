package com.codex.casadocodigo.core.model.dto

import com.codex.casadocodigo.core.model.Autor
import com.codex.casadocodigo.core.model.Categoria
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import java.time.LocalDate

@JsonInclude(NON_NULL)
data class LivroOut(
        val id: Long,
        val titulo: String,
        val resumo: String?,
        val sumario: String?,
        val preco: Double?,
        val numPaginas: Int?,
        val isbn: String?,
        val dataLancamento: LocalDate?,
        val categoria: Categoria?,
        val autor: Autor?
)