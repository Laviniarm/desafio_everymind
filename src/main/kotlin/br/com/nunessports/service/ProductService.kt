package br.com.nunessports.service

import br.com.nunessports.dto.CreateProductDTO
import br.com.nunessports.dto.UpdateProductDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface ProductService {
    fun create(createProductDTO: CreateProductDTO)
    fun update(identifier: UUID, updateProductDTO: UpdateProductDTO)
    fun delete(identifier: UUID)
    fun <T> findByIdentifier(identifier: UUID, type: Class<T>): T
    fun <T> findPage(pageable: Pageable, type: Class<T>): Page<T>
}