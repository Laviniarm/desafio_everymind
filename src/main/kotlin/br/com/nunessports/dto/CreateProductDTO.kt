package br.com.nunessports.dto

import br.com.nunessports.common.util.ValidationMessages
import br.com.nunessports.models.ProductModel
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateProductDTO(
    @field:NotBlank(message = ValidationMessages.NOT_BLANK)
    @field:Size(max = 20)
    val name: String,
    @field:Size(max = 255)
    val description: String,
    @field:NotNull(message = ValidationMessages.NOT_BLANK)
    val value: Double
){
    fun toEntity() : ProductModel = ProductModel(
        name = name,
        description = description,
        value = value
    )
}

