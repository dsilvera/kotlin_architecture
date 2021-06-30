package com.dsilvera.kotlinarchitecture.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Product(
    val id: String,
    val ingredientsText: String,
    val imageUrl: String,
    val code: String,
    val brand: String,
    val genericName: String,
    val labels: String,
    val nutriscoreScore: Int,
    val nutriscoreGrade: String,
    val ecoscoreScore: Int,
    val ecoscoreGrade: String
): Parcelable {
    fun score() = ecoscoreScore - nutriscoreScore
}