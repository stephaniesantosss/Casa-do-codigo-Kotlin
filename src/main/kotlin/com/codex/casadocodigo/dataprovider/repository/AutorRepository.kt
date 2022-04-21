package com.codex.casadocodigo.dataprovider.repository

import com.codex.casadocodigo.core.model.Autor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AutorRepository : JpaRepository<Autor, Long> {
}