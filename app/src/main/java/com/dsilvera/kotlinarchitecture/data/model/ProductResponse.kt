package com.dsilvera.kotlinarchitecture.data.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ProductResponse(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "ingredients_text")
    val ingredientsText: String,
    @field:Json(name = "image_url")
    val imageUrl: String,
    @field:Json(name = "code")
    val code: String,
    @field:Json(name = "brands")
    val brand: String,
    @field:Json(name = "generic_name")
    val genericName: String,
    @field:Json(name = "labels")
    val labels: String,
    @field:Json(name = "nutriscore_score")
    val nutriscoreScore: Int,
    @field:Json(name = "nutriscore_grade")
    val nutriscoreGrade: String,
    @field:Json(name = "ecoscore_score")
    val ecoscoreScore: Int,
    @field:Json(name = "ecoscore_grade")
    val ecoscoreGrade: String
)