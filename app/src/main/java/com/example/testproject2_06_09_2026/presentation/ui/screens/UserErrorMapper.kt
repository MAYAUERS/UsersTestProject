package com.example.testproject2_06_09_2026.presentation.ui.screens

import com.example.testproject2_06_09_2026.domain.apperror.AppError

fun AppError.toAppErrorMessage(): String{
    return when(this){
        is AppError.NoInternet ->"No Network Please try again."
        is AppError.Network ->"Please your network"
        is AppError.TimeOut->"Sever Error,Please try again."
        is AppError.Unauthorized->"User is unauthorized"
        is AppError.Server->"Sever Error."
        is AppError.Unknown->"Something went wrong."
    }
}