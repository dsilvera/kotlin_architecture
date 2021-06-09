package com.dsilvera.kotlinarchitecture.data.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Keep
@Entity(tableName = "product")
data class ProductResponse(
    @PrimaryKey
    @field:Json(name = "id")
    val id: String,
    @ColumnInfo(name = "ingredients_text")
    @field:Json(name = "ingredients_text")
    val ingredientsText: String,
    @ColumnInfo(name = "image_url")
    @field:Json(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "code")
    @field:Json(name = "code")
    val code: String,
    @ColumnInfo(name = "brands")
    @field:Json(name = "brands")
    val brand: String,
    @ColumnInfo(name = "generic_name")
    @field:Json(name = "generic_name")
    val genericName: String,
    @ColumnInfo(name = "labels")
    @field:Json(name = "labels")
    val labels: String,
    @ColumnInfo(name = "nutriscore_score")
    @field:Json(name = "nutriscore_score")
    val nutriscoreScore: Int,
    @ColumnInfo(name = "nutriscore_grade")
    @field:Json(name = "nutriscore_grade")
    val nutriscoreGrade: String,
    @ColumnInfo(name = "ecoscore_score")
    @field:Json(name = "ecoscore_score")
    val ecoscoreScore: Int,
    @ColumnInfo(name = "ecoscore_grade")
    @field:Json(name = "ecoscore_grade")
    val ecoscoreGrade: String
)