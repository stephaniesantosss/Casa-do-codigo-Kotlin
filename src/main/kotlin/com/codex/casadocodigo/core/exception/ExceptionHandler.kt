package com.codex.casadocodigo.core.exception

import com.codex.casadocodigo.core.model.dto.ErrorResponse
import org.springframework.dao.DuplicateKeyException
import org.springframework.http.HttpStatus.*
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

    @ExceptionHandler(DuplicateKeyException::class)
    @ResponseStatus(CONFLICT)
    fun duplicateKeyException(
            exception: Exception,
            request: HttpServletRequest
    ): ErrorResponse {
        return ErrorResponse(
                status = CONFLICT.value(),
                error = CONFLICT.name,
                message = exception.message.toString(),
                path = request.servletPath
        )
    }

    @ExceptionHandler(ClassNotFoundException::class)
    @ResponseStatus(NOT_FOUND)
    fun notFoundException(
            exception: Exception,
            request: HttpServletRequest
    ): ErrorResponse {
        return ErrorResponse(
                status = NOT_FOUND.value(),
                error = NOT_FOUND.name,
                message = exception.message.toString(),
                path = request.servletPath
        )
    }
}