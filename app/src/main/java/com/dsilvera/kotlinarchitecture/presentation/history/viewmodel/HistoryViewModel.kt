package com.dsilvera.kotlinarchitecture.presentation.history.viewmodel

import androidx.lifecycle.*
import com.dsilvera.kotlinarchitecture.domain.entity.Product
import com.dsilvera.kotlinarchitecture.domain.resource.Resource
import com.dsilvera.kotlinarchitecture.domain.usecase.ProductUseCase
import com.dsilvera.kotlinarchitecture.presentation.common.extension.contextIO

class HistoryViewModel(private val productUseCase: ProductUseCase) : ViewModel() {
    private val getAllProductsParams = MutableLiveData<GetAllProductsParams>()
    val getAllProductsResult: LiveData<Resource<List<Product>>> = getAllProductsParams.switchMap { params ->
        productUseCase.getAllProduct().asLiveData(contextIO())
    }

    fun getAllProducts() {
        getAllProductsParams.value = GetAllProductsParams()
    }

    private class GetAllProductsParams
}