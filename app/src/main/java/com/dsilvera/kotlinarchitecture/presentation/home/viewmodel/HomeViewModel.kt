package com.dsilvera.kotlinarchitecture.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dsilvera.kotlinarchitecture.domain.usecase.UserUseCase

class HomeViewModel(private val userUseCase: UserUseCase) : ViewModel() {
    val scoreUpdateEvent = userUseCase.scoreUpdateEvent.asLiveData()
    fun getScore() = userUseCase.getScore()
}