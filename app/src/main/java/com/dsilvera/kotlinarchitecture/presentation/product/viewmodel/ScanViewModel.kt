package com.dsilvera.kotlinarchitecture.presentation.product.viewmodel

import androidx.lifecycle.*
import com.dsilvera.kotlinarchitecture.domain.entity.Product
import com.dsilvera.kotlinarchitecture.domain.resource.Resource
import com.dsilvera.kotlinarchitecture.domain.usecase.ProductUseCase
import com.dsilvera.kotlinarchitecture.presentation.common.extension.contextIO

class ScanViewModel(private val productUseCase: ProductUseCase) : ViewModel() {
    private val getProductParams = MutableLiveData<GetProductParams>()
    val getProductResult: LiveData<Resource<Product>> = getProductParams.switchMap { params ->
        productUseCase.getProduct(params.barcode).asLiveData(contextIO())
    }

    fun getProduct(barcode:String) {
        getProductParams.value = GetProductParams(barcode)
    }

    private class GetProductParams(val barcode: String)
}