package com.dsilvera.kotlinarchitecture.data.api

import com.dsilvera.kotlinarchitecture.data.model.ProductResultResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface RemoteApi {
    @GET("product/{barcode}")
    suspend fun getProduct(@Path("barcode") barcode: String) : ProductResultResponse
}