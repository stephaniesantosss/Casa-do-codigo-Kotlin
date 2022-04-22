package com.codex.casadocodigo.dataprovider.gateway.impl

import com.codex.casadocodigo.core.model.Estado
import com.codex.casadocodigo.dataprovider.gateway.EstadoGateway
import com.codex.casadocodigo.dataprovider.repository.EstadoRepository
import com.codex.casadocodigo.dataprovider.repository.PaisRepository
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Component

@Component
class EstadoGatewayImpl(
        val estadoRepository: EstadoRepository,
        val paisRepository: PaisRepository
) : EstadoGateway {

    override fun salvaEstado(estado: Estado) {
        paisRepository.findById(estado.pais.id!!).let {
            if (it.isEmpty)
                throw ClassNotFoundException("IdPais não foi encontrado, favor informar outro")
            else if (estadoRepository.existsByNome(estado.nome))
                throw DuplicateKeyException("Este pais já está cadastrado, favor informar outro")
            estadoRepository.save(estado)
        }
    }
}