package com.codex.casadocodigo.core.translate

import com.codex.casadocodigo.core.model.Pais
import com.codex.casadocodigo.core.model.dto.PaisIn

fun translatePaisInToPais(paisIn: PaisIn): Pais {
    return Pais(
            id = null,
            nome = paisIn.nome.uppercase()
    )
}