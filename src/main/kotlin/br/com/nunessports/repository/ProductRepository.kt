package br.com.nunessports.repository

import br.com.nunessports.models.ProductModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository: JpaRepository<ProductModel, UUID> {
    fun <T> findByIdentifier(identifier: UUID, type: Class<T>): T?
    fun existsByName (name: String): Boolean
    fun <T> findBy(pageable: Pageable, type: Class<T>): Page<T>
}