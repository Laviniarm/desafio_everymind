package br.com.nunessports.common.extensions

import br.com.nunessports.common.exceptions.NotFoundException
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

fun <T> JpaRepository<T, UUID>.findOrThrow(identifier: UUID) =
    (findById(identifier).takeIf { it.isPresent } ?: throw NotFoundException()).get()
