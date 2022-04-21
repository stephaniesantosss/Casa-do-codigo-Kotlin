package com.codex.casadocodigo.dataprovider.gateway

import com.codex.casadocodigo.core.model.Categoria

interface CategoriaGateway {

    fun salvaCategoria(categoria: Categoria)
}