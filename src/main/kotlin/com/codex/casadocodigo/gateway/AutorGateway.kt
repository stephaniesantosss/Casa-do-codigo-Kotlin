package com.codex.casadocodigo.gateway

import com.codex.casadocodigo.model.Autor

interface AutorGateway {

    fun salvaAutor(autor: Autor)
}