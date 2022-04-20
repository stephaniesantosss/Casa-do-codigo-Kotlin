package com.codex.casadocodigo.gateway.impl

import com.codex.casadocodigo.gateway.AutorGateway
import com.codex.casadocodigo.model.Autor
import com.codex.casadocodigo.repository.AutorRepository
import org.springframework.stereotype.Component

@Component
class AutorGatewayImpl(val autorRepository: AutorRepository) : AutorGateway {

    override fun salvaAutor(autor: Autor) {
        autorRepository.save(autor)
    }
}