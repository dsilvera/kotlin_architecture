package com.dsilvera.kotlinarchitecture.domain.repository

import com.dsilvera.kotlinarchitecture.domain.entity.Product
import com.dsilvera.kotlinarchitecture.domain.entity.ScoreUpdateEvent
import kotlinx.coroutines.flow.MutableSharedFlow

interface UserRepository {
    val scoreUpdateEvent: MutableSharedFlow<ScoreUpdateEvent>
    fun getScore(): Int
    suspend fun updateScore(product: Product)
}