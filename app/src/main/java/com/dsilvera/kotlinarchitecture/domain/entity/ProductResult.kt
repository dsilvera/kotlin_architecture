package com.dsilvera.kotlinarchitecture.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class ProductResult(
    val status:Int,
    val product: Product?,
) : Parcelable