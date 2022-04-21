package com.codex.casadocodigo.dataprovider.repository

import com.codex.casadocodigo.core.model.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoriaRepository : JpaRepository<Categoria, Long> {

    fun findByNome(nome: String): Optional<Categoria>
}