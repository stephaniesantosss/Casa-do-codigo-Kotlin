package com.codex.casadocodigo.dataprovider.repository

import com.codex.casadocodigo.core.model.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository : JpaRepository<Categoria, Long> {

    fun existsByNome(nome: String): Boolean
}