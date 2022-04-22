package com.codex.casadocodigo.entrypoint.controller.api

import com.codex.casadocodigo.core.model.dto.LivroIn
import com.codex.casadocodigo.core.model.dto.LivroOut
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/livro")
interface LivroControllerApi {

    @ResponseStatus(OK)
    @PostMapping
    fun salvaLivro(@Valid @RequestBody livroIn: LivroIn)

    @ResponseStatus(OK)
    @GetMapping
    fun buscaLivros(): List<LivroOut>

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    fun buscaDetalhesLivro(@PathVariable("id") id: Long): LivroOut
}