package com.example.testproject2_06_09_2026.presentation.ui.screens

import com.example.testproject2_06_09_2026.domain.apperror.AppError

sealed class UserUiState<out T> {
    data object Loading : UserUiState<Nothing>()
    data object Empty : UserUiState<Nothing>()
    data class Success<out T>(val data: T) : UserUiState<T>()
    data class Error(val error: AppError) : UserUiState<Nothing>()
}
