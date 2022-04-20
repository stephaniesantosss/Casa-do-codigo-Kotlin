package com.codex.casadocodigo.usecase

import com.codex.casadocodigo.AutorIn
import com.codex.casadocodigo.gateway.AutorGateway
import com.codex.casadocodigo.model.Autor
import com.codex.casadocodigo.translate.translateAutorInToAutor
import org.springframework.stereotype.Component

@Component
class AutorUseCase(val autorGateway: AutorGateway) {

    fun salvaAutor(autorIn: AutorIn){
    val autor: Autor = translateAutorInToAutor(autorIn)
        autorGateway.salvaAutor(autor)
    }
}