package com.codex.casadocodigo.dataprovider.gateway.impl

import com.codex.casadocodigo.core.model.Categoria
import com.codex.casadocodigo.dataprovider.gateway.CategoriaGateway
import com.codex.casadocodigo.dataprovider.repository.CategoriaRepository
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Component

@Component
class CategoriaGatewayImpl(val categoriaRepository: CategoriaRepository) : CategoriaGateway {

    override fun salvaCategoria(categoria: Categoria) {

        categoriaRepository.findByNome(categoria.nome).ifPresent {
            throw DuplicateKeyException("Está categoria já está cadastrada, favor informar outra")
        }

        categoriaRepository.save(categoria)
    }
}