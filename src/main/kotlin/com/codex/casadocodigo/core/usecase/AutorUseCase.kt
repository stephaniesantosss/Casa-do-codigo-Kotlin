package com.codex.casadocodigo.core.usecase

import com.codex.casadocodigo.core.model.dto.AutorIn
import com.codex.casadocodigo.dataprovider.gateway.AutorGateway
import com.codex.casadocodigo.core.model.Autor
import com.codex.casadocodigo.core.translate.translateAutorInToAutor
import org.springframework.stereotype.Component

@Component
class AutorUseCase(val autorGateway: AutorGateway) {

    fun salvaAutor(autorIn: AutorIn){
    val autor: Autor = translateAutorInToAutor(autorIn)
        autorGateway.salvaAutor(autor)
    }
}