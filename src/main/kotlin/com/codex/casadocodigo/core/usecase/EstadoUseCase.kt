package com.codex.casadocodigo.core.usecase

import com.codex.casadocodigo.core.model.dto.EstadoIn
import com.codex.casadocodigo.core.translate.translateEstadoInToEstado
import com.codex.casadocodigo.dataprovider.gateway.EstadoGateway
import org.springframework.stereotype.Component

@Component
class EstadoUseCase(val estadoGateway: EstadoGateway) {

    fun salvaEstado(estadoIn: EstadoIn) {
        val estado = translateEstadoInToEstado(estadoIn)
        estadoGateway.salvaEstado(estado)
    }
}