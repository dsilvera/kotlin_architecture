package com.dsilvera.kotlinarchitecture.data.repository

import com.dsilvera.kotlinarchitecture.data.api.RemoteApi
import com.dsilvera.kotlinarchitecture.data.database.ProductDao
import com.dsilvera.kotlinarchitecture.domain.entity.Product
import com.dsilvera.kotlinarchitecture.domain.entity.ProductResult
import com.dsilvera.kotlinarchitecture.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val remoteApi: RemoteApi,
    private val productDao: ProductDao
) : ProductRepository {
    override fun getCachedProduct(barcode: String): Product? {
        return productDao.find(barcode)?.toModel()
    }

    override suspend fun getProduct(barcode: String): ProductResult {
        val productResultResponse = remoteApi.getProduct(barcode)
        val product = productResultResponse.product
        if (product != null) {
            productDao.insertAll(product)
        }
        return productResultResponse.toModel()
    }

    override fun getAllProducts(): List<Product> {
        return productDao.getAll().map { it.toModel() }
    }
}