package com.codex.casadocodigo.core.usecase

import com.codex.casadocodigo.core.model.dto.PaisIn
import com.codex.casadocodigo.core.translate.translatePaisInToPais
import com.codex.casadocodigo.dataprovider.gateway.PaisGateway
import org.springframework.stereotype.Component

@Component
class PaisUseCase(val paisGateway: PaisGateway) {

    fun salvaPais(paisIn: PaisIn) {
        val pais = translatePaisInToPais(paisIn)
        paisGateway.salvaPais(pais)
    }
}