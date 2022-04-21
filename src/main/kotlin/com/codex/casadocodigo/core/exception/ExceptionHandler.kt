package com.codex.casadocodigo.core.exception

import com.codex.casadocodigo.core.model.dto.ErrorResponse
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationError(
            exception: MethodArgumentNotValidException,
            request: HttpServletRequest
    ): ErrorResponse {
        val errorMessage = HashMap<String, String?>()
        exception.bindingResult.fieldErrors.forEach { e ->
            errorMessage[e.field] = e.defaultMessage
        }
        return ErrorResponse(
                status = BAD_REQUEST.value(),
                error = BAD_REQUEST.name,
                message = errorMessage.toString(),
                path = request.servletPath
        )
    }
}