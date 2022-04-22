package com.codex.casadocodigo.dataprovider.gateway

import com.codex.casadocodigo.core.model.Estado

interface EstadoGateway {

    fun salvaEstado(estado: Estado)
}