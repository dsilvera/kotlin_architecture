package com.dsilvera.kotlinarchitecture.domain.usecase

import com.dsilvera.kotlinarchitecture.domain.repository.UserRepository

class UserUseCase(
    private val userRepository: UserRepository
) {
    val scoreUpdateEvent = userRepository.scoreUpdateEvent

    fun getScore() = userRepository.getScore()
}