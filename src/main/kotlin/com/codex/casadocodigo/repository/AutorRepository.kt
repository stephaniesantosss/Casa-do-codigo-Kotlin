package com.codex.casadocodigo.repository

import com.codex.casadocodigo.model.Autor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AutorRepository : JpaRepository<Autor, Long> {
}