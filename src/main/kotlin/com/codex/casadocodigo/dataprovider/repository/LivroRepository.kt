package com.codex.casadocodigo.dataprovider.repository

import com.codex.casadocodigo.core.model.Livro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LivroRepository : JpaRepository<Livro, Long> {

    fun existsByTitulo(titulo: String): Boolean
    fun existsByIsbn(isbn: String): Boolean
}