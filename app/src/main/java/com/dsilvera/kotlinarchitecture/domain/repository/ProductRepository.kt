package com.dsilvera.kotlinarchitecture.domain.repository

import com.dsilvera.kotlinarchitecture.domain.entity.Product
import com.dsilvera.kotlinarchitecture.domain.entity.ProductResult

interface ProductRepository {
    fun getCachedProduct(barcode: String): Product?
    suspend fun getProduct(barcode: String): ProductResult
    fun getAllProducts(): List<Product>
}