package com.codex.casadocodigo.core.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.AUTO
import javax.persistence.Id

@Entity
data class Pais(
        @Id @GeneratedValue(strategy = AUTO)
        val id: Long ?,
        @field:Column(unique = true)
        val nome: String ?
)
