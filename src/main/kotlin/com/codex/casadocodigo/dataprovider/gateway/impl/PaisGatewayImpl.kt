package com.codex.casadocodigo.dataprovider.gateway.impl

import com.codex.casadocodigo.core.model.Pais
import com.codex.casadocodigo.dataprovider.gateway.PaisGateway
import com.codex.casadocodigo.dataprovider.repository.PaisRepository
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Component

@Component
class PaisGatewayImpl(val paisRepository: PaisRepository) : PaisGateway {

    override fun salvaPais(pais: Pais) {
        paisRepository.existsByNome(pais.nome!!).let {
            if (it)
                throw DuplicateKeyException("Este Pais já está cadastrado, favor informar outro")
            paisRepository.save(pais)
        }
    }
}