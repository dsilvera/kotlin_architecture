package com.dsilvera.kotlinarchitecture.domain.resource

/** Resource to map data with its loading state. */
sealed class Resource<T> {
    /** Progress status. */
    data class Progress<T>(val data: T? = null, val tag: String? = null) : Resource<T>()

    /** Success status. */
    data class Success<T>(val data: T, val tag: String? = null) : Resource<T>()

    /** Failure status. */
    data class Failure<T>(val throwable: Throwable, val data: T? = null, val tag: String? = null) :
        Resource<T>()

    companion object {
        /** Get a [Resource] in loading state with provided [data]. */
        fun <T> loading(data: T? = null, tag: String? = null): Resource<T> =
            Progress(data, tag)

        /** Get a [Resource] in success state with provided [data]. */
        fun <T> success(data: T, tag: String? = null): Success<T> =
            Success(data, tag)

        /** Get a [Resource] in failure state with provided [throwable]. */
        fun <T> failure(throwable: Throwable, data: T? = null, tag: String? = null): Resource<T> =
            Failure(throwable, data, tag)
    }
}