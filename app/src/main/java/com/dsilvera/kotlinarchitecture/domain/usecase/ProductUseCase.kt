package com.dsilvera.kotlinarchitecture.domain.usecase

import android.content.res.Resources
import com.dsilvera.kotlinarchitecture.domain.entity.Product
import com.dsilvera.kotlinarchitecture.domain.repository.ProductRepository
import com.dsilvera.kotlinarchitecture.domain.repository.UserRepository
import com.dsilvera.kotlinarchitecture.domain.resource.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class ProductUseCase(
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository
) {

    fun getProduct(barcode:String) = flow<Resource<Product>> {
        val cachedProduct = productRepository.getCachedProduct(barcode)
        if (cachedProduct != null) {
            emit(Resource.success(cachedProduct))
        } else {
            val data = productRepository.getProduct(barcode)
            val product = data.product ?: throw Resources.NotFoundException()
            userRepository.updateScore(product = product)
            emit(Resource.success(product))
        }
    }.catch {
        emit(Resource.failure(it))
    }

    fun getAllProduct() = flow<Resource<List<Product>>> {
        emit(Resource.success(productRepository.getAllProducts()))
    }.catch {
        emit(Resource.failure(it))
    }
}