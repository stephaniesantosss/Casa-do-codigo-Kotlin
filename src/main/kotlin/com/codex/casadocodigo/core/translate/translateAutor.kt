package com.codex.casadocodigo.core.translate

import com.codex.casadocodigo.core.model.dto.AutorIn
import com.codex.casadocodigo.core.model.Autor

fun translateAutorInToAutor(autorIn: AutorIn): Autor {
    return Autor(
            id = null,
            nome = autorIn.nome,
            email = autorIn.email,
            descricao = autorIn.descricao
    )
}