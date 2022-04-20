package com.codex.casadocodigo.translate

import com.codex.casadocodigo.AutorIn
import com.codex.casadocodigo.model.Autor

fun translateAutorInToAutor(autorIn: AutorIn): Autor {
    return Autor(
            id = null,
            nome = autorIn.nome,
            email = autorIn.email,
            descricao = autorIn.descricao
    )
}