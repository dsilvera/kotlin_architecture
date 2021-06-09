package com.dsilvera.kotlinarchitecture.data.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ProductResultResponse(
    @field:Json(name = "status")
    val status:Int,
    @field:Json(name = "product")
    val product: ProductResponse?,
)