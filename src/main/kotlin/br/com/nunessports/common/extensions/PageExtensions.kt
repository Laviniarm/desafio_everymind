package br.com.nunessports.common.extensions

import org.springframework.data.domain.Page
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.util.CollectionUtils

fun <T> Page<T>.toOkResponseEntity(): ResponseEntity<List<T>> {
    val headers = mapOf(
        "TotalPages" to listOf("$totalPages"),
        "TotalElements" to listOf("$totalElements"),
        "Index" to listOf("$number"),
        "NumberOfElements" to listOf("$numberOfElements")
    )
    val multiValueHeaders = CollectionUtils.toMultiValueMap(headers)
    return ResponseEntity.ok()
        .headers(HttpHeaders.readOnlyHttpHeaders(multiValueHeaders))
        .body(toList())

}