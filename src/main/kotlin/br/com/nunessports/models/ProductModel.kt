package br.com.nunessports.models

import br.com.nunessports.dto.ProductDTO
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tb_product")
data class ProductModel(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID")
    var identifier: UUID? = null,

    @Column(columnDefinition = "varchar(20)", nullable = false)
    var name: String,

    @Column(columnDefinition = "varchar(255)", nullable = false)
    var description : String,

    @Column(nullable = false)
    var value : Double
) {
    constructor() : this(null, "", "", 0.0)

    fun toDTO() = ProductDTO(
        identifier = identifier,
        name = name,
        description = description,
        value = value
    )
}