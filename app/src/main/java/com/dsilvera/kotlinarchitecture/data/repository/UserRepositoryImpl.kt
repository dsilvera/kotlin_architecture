package com.dsilvera.kotlinarchitecture.data.repository

import com.dsilvera.kotlinarchitecture.data.api.LocalApi
import com.dsilvera.kotlinarchitecture.domain.entity.Product
import com.dsilvera.kotlinarchitecture.domain.entity.ScoreUpdateEvent
import com.dsilvera.kotlinarchitecture.domain.repository.UserRepository
import kotlinx.coroutines.flow.MutableSharedFlow

class UserRepositoryImpl(
    private val localApi: LocalApi
) : UserRepository {
    override val scoreUpdateEvent = MutableSharedFlow<ScoreUpdateEvent>()

    override fun getScore() = localApi.getScore()

    override suspend fun updateScore(product: Product) {
        val score = localApi.getScore() + product.score()
        localApi.saveScore(score)
        scoreUpdateEvent.emit(ScoreUpdateEvent(score))
    }
}