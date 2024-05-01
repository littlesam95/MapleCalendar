package com.bodan.maplecalendar.presentation.utils

data class Result<out T>(
    val status: Status,
    val data: @UnsafeVariance T?,
    val message: String?
) {

    companion object {

        fun <T> success(data: T?): Result<T> {
            return Result(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T?): Result<T> {
            return Result(Status.ERROR, data, message)
        }

        fun <T> fail(): Result<T> {
            return Result(Status.FAIL, null, null)
        }

        fun <T> loading(data: T?): Result<T> {
            return Result(Status.LOADING, data, null)
        }
    }
}
