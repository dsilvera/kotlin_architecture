package com.dsilvera.kotlinarchitecture.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dsilvera.kotlinarchitecture.data.model.ProductResponse

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAll(): List<ProductResponse>

    @Query("SELECT * FROM product WHERE code = :barcode LIMIT 1")
    fun find(barcode: String): ProductResponse?

    @Insert
    fun insertAll(vararg products: ProductResponse)

    @Delete
    fun delete(product: ProductResponse)
}