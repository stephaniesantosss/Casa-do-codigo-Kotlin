package com.codex.casadocodigo.dataprovider.gateway.impl

import com.codex.casadocodigo.core.model.Autor
import com.codex.casadocodigo.dataprovider.gateway.AutorGateway
import com.codex.casadocodigo.dataprovider.repository.AutorRepository
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Component

@Component
class AutorGatewayImpl(val autorRepository: AutorRepository) : AutorGateway {

    override fun salvaAutor(autor: Autor) {

        autorRepository.findByEmail(autor.email).ifPresent {
            throw DuplicateKeyException("Este email já está cadastrado, favor informar outro")
        }

        autorRepository.save(autor)
    }
}