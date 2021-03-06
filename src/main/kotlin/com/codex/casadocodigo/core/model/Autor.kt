package com.codex.casadocodigo.core.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.AUTO
import javax.persistence.Id

@Entity
data class Autor(
        @Id @GeneratedValue(strategy = AUTO)
        val id: Long ?,
        val nome: String,
        @field:Column(unique = true)
        val email: String,
        val descricao: String
)