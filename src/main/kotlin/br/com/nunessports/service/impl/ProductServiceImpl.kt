package br.com.nunessports.service.impl


import br.com.nunessports.common.exceptions.NotFoundException
import br.com.nunessports.common.exceptions.NotUniqueException
import br.com.nunessports.dto.CreateProductDTO
import br.com.nunessports.dto.UpdateProductDTO
import br.com.nunessports.models.ProductModel
import br.com.nunessports.repository.ProductRepository
import br.com.nunessports.service.ProductService
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
open class ProductServiceImpl (
    private val productRepository: ProductRepository
): ProductService {

    @Transactional
    override fun create(createProductDTO: CreateProductDTO) {
        createProductDTO.toEntity().run {
            if (!productExists()){
                productRepository.save(this)
            } else{
                throw NotUniqueException("Produto já existente para o estabelecimento")
            }
        }
    }

    override fun update(identifier: UUID, updateProductDTO: UpdateProductDTO) {
        val product = findByIdentifier(identifier, ProductModel::class.java)
        updateProductDTO.update(product)
        productRepository.save(product)
    }

    override fun delete(identifier: UUID) {
        productRepository.deleteById(identifier);
    }

    override fun <T> findByIdentifier(identifier: UUID, type: Class<T>): T =
        productRepository
            .findByIdentifier(identifier, type) ?: throw NotFoundException()


    override fun <T> findPage(pageable: Pageable, type: Class<T>): Page<T> =
        productRepository
            .findBy(pageable, type)

    private fun ProductModel.productExists() =
        productRepository.existsByName(this.name)
}