package br.com.nunessports.dto

import java.util.*

data class ProductDTO (
    val identifier: UUID?,
    val name: String,
    val description: String,
    val value: Double
)