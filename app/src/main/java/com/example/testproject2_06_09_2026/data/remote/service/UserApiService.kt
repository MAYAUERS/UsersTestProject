package com.example.testproject2_06_09_2026.data.remote.service

import com.example.testproject2_06_09_2026.data.remote.dto.UserDtoItem
import retrofit2.http.GET

interface UserApiService {

    @GET("users")
    suspend fun getAllUsers(): List<UserDtoItem>
}