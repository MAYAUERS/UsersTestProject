package com.example.testproject2_06_09_2026.domain.apperror

sealed interface AppError {

    data object NoInternet : AppError
    data object Network : AppError
    data object Server : AppError
    data object TimeOut : AppError
    data object Unauthorized : AppError
    data object Unknown : AppError
}