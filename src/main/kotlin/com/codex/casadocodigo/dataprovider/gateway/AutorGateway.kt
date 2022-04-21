package com.codex.casadocodigo.dataprovider.gateway

import com.codex.casadocodigo.core.model.Autor

interface AutorGateway {

    fun salvaAutor(autor: Autor)
}