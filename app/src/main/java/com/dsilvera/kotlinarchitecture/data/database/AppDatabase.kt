package com.dsilvera.kotlinarchitecture.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dsilvera.kotlinarchitecture.data.model.ProductResponse

@Database(entities = [ProductResponse::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}