package com.codex.casadocodigo.core.translate

import com.codex.casadocodigo.core.model.Categoria
import com.codex.casadocodigo.core.model.dto.CategoriaIn

fun translateCategoriaInToCategoria(categoriaIn: CategoriaIn): Categoria {
    return Categoria(
            id = null,
            nome = categoriaIn.nome.uppercase()
    )
}