package com.codex.casadocodigo.core.usecase

import com.codex.casadocodigo.core.model.dto.CategoriaIn
import com.codex.casadocodigo.core.translate.translateCategoriaInToCategoria
import com.codex.casadocodigo.dataprovider.gateway.CategoriaGateway
import org.springframework.stereotype.Component

@Component
class CategoriaUseCase(val categoriaGateway: CategoriaGateway) {

    fun salvaCategoria(categoriaIn: CategoriaIn) {
        val categoria = translateCategoriaInToCategoria(categoriaIn)
        categoriaGateway.salvaCategoria(categoria)
    }
}