package com.codex.casadocodigo.dataprovider.repository

import com.codex.casadocodigo.core.model.Pais
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaisRepository : JpaRepository<Pais, Long> {

    fun existsByNome(nome: String): Boolean
}