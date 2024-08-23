package br.com.nunessports.dto

import br.com.nunessports.common.util.ValidationMessages
import br.com.nunessports.models.ProductModel
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PositiveOrZero
import jakarta.validation.constraints.Size

data class UpdateProductDTO(
    @field:NotBlank(message = ValidationMessages.NOT_BLANK)
    @field:Size(max = 20)
    val name: String,
    @field:Size(max = 255)
    val description: String,
    @field:NotNull(message = ValidationMessages.NOT_BLANK)
    @field:PositiveOrZero(message = ValidationMessages.POSITIVE)
    val value: Double
){
    fun update(productModel: ProductModel){
        name.also{productModel.name = it}
        description.also{productModel.description = it}
        value.also{productModel.value = it}
    }
}
