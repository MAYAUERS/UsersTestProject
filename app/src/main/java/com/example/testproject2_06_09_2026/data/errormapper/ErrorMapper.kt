package com.example.testproject2_06_09_2026.data.errormapper

import android.net.Network
import com.example.testproject2_06_09_2026.domain.apperror.AppError
import okio.IOException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class ErrorMapper @Inject constructor() {

    fun map(throwable: Throwable): AppError {
        return when (throwable) {
            is UnknownHostException -> AppError.NoInternet
            is SocketTimeoutException -> AppError.TimeOut
            is IOException -> AppError.Network

            is HttpException -> {
                when (throwable.code()) {
                    401 -> AppError.Unauthorized
                    in 500..599 -> AppError.Server
                    else -> AppError.Unknown
                }
            }

            else -> AppError.Unknown
        }
    }
}