package br.com.nunessports.common.handlers

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime


@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class ErrorDetail(
    val statusCode: Int = 0,
    val message: String? = null,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val timestamp: LocalDateTime? = null,
    val path: String? = null,
    val errors: Map<String, String> = mutableMapOf()
)