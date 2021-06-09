package com.dsilvera.kotlinarchitecture.data.api

import android.app.Application
import android.content.Context

interface LocalApi {
    fun saveScore(score: Int)
    fun getScore(): Int
}

class LocalApiImpl(appContext: Application) : LocalApi {
    private val sharedPreferences = appContext.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)


    override fun saveScore(score: Int) {
        sharedPreferences.edit().putInt(SCORE_KEY, score).apply()
    }

    override fun getScore() = sharedPreferences.getInt(SCORE_KEY, 0)


    companion object {
        private const val PREFERENCE_FILE_NAME = "TutoTropFunDeOuf"
        private const val SCORE_KEY = "Score"
    }
}