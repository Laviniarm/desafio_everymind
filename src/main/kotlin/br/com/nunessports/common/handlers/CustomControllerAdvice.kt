package br.com.nunessports.common.handlers

import br.com.nunessports.common.exceptions.NotFoundException
import br.com.nunessports.common.exceptions.NotUniqueException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime


@RestControllerAdvice
class CustomControllerAdvice: ResponseEntityExceptionHandler() {

    @ExceptionHandler(NotUniqueException::class)
    fun handleBadRequestException(ex: RuntimeException, request: HttpServletRequest): ResponseEntity<ErrorDetail> {
        return buildResponse(HttpStatus.BAD_REQUEST, request, ex)
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: RuntimeException, request: HttpServletRequest): ResponseEntity<ErrorDetail> {
        return buildResponse(HttpStatus.NOT_FOUND, request, ex)
    }


    private fun buildResponse(
        status: HttpStatus,
        request: HttpServletRequest,
        ex: Exception
    ): ResponseEntity<ErrorDetail> {
        return ResponseEntity.status(status).body(
            ErrorDetail(
                statusCode = status.value(),
                message = ex.message,
                timestamp = LocalDateTime.now(),
                path = request.pathInfo,
                errors = mapOf()
            )

        )
    }
}