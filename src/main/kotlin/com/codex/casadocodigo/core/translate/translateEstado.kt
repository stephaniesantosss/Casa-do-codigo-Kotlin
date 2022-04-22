package com.codex.casadocodigo.core.translate

import com.codex.casadocodigo.core.model.Estado
import com.codex.casadocodigo.core.model.Pais
import com.codex.casadocodigo.core.model.dto.EstadoIn

fun translateEstadoInToEstado(estadoIn: EstadoIn): Estado {
    return Estado(
            id = null,
            nome = estadoIn.nome.uppercase(),
            pais = Pais(
                    id = estadoIn.idPais,
                    nome = null)
    )
}