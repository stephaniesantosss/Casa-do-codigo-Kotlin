package com.codex.casadocodigo.core.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.AUTO
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Categoria(
        @Id @GeneratedValue(strategy = AUTO)
        val id: Long ?,
        @field:NotBlank
        val nome: String
)
