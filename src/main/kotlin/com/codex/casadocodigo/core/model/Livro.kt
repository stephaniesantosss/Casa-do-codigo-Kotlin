package com.codex.casadocodigo.core.model

import java.time.LocalDate
import javax.persistence.*
import javax.persistence.GenerationType.AUTO

@Entity
data class Livro(
        @Id @GeneratedValue(strategy = AUTO)
        val id: Long?,
        @field:Column(unique = true)
        val titulo: String,
        val resumo: String,
        val sumario: String,
        val preco: Double,
        val numPaginas: Int,
        @field:Column(unique = true)
        val isbn: String,
        val dataLancamento: LocalDate,
        @field:OneToOne
        val categoria: Categoria,
        @field:OneToOne
        val autor: Autor
)