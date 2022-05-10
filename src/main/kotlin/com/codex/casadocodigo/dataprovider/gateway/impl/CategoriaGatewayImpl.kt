package com.codex.casadocodigo.dataprovider.gateway.impl

import com.codex.casadocodigo.core.model.Categoria
import com.codex.casadocodigo.dataprovider.gateway.CategoriaGateway
import com.codex.casadocodigo.dataprovider.repository.CategoriaRepository
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Component

@Component
class CategoriaGatewayImpl(val categoriaRepository: CategoriaRepository) : CategoriaGateway {

    override fun salvaCategoria(categoria: Categoria) {

        categoriaRepository.existsByNome(categoria.nome).let {
            if (it)
                throw DuplicateKeyException("Esta categoria já está cadastrada, favor informar outra")
        }

        categoriaRepository.save(categoria)
    }
}