package com.codex.casadocodigo.core.model

import javax.persistence.*
import javax.persistence.GenerationType.AUTO

@Entity
data class Estado(
        @Id @GeneratedValue(strategy = AUTO)
        val id: Long?,
        @field:Column(unique = true)
        val nome: String,
        @field:OneToOne
        val pais: Pais
)