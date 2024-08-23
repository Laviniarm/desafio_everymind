package br.com.nunessports.controllers

import br.com.nunessports.dto.CreateProductDTO
import br.com.nunessports.dto.ProductDTO
import br.com.nunessports.dto.UpdateProductDTO
import br.com.nunessports.models.ProductModel
import br.com.nunessports.service.ProductService
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/product")
class ProductController (
    private val service: ProductService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid createProductDTO: CreateProductDTO) {
        service.create(createProductDTO)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @PathVariable(name = "id") identifier: UUID,
        @RequestBody @Valid updateProductDTO: UpdateProductDTO
    ) {
        service.update(identifier, updateProductDTO)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable(name = "id") identifier: UUID
    ) {
        service.delete(identifier)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun find(@PathVariable(name = "id") identifier: UUID): ProductDTO =
        service.findByIdentifier(identifier, ProductModel::class.java).toDTO()

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun find(pageable: Pageable): MutableList<ProductDTO> =
        service.findPage(pageable, ProductModel::class.java).map{it.toDTO()}.toList()
}