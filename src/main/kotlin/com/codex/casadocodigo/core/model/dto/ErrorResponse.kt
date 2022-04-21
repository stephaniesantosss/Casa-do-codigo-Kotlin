package com.codex.casadocodigo.core.model.dto

import lombok.Getter
import java.time.LocalDateTime

@Getter
data class ErrorResponse(
        val timestamp: LocalDateTime = LocalDateTime.now(),
        val status: Int,
        val error: String,
        val message: String,
        val path: String
) {
}