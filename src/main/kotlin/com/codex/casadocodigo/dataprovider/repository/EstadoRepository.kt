package com.codex.casadocodigo.dataprovider.repository

import com.codex.casadocodigo.core.model.Estado
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EstadoRepository : JpaRepository<Estado, Long> {

    fun existsByNome(nome: String): Boolean
}