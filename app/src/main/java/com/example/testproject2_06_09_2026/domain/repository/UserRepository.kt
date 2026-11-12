package com.example.testproject2_06_09_2026.domain.repository

import com.example.testproject2_06_09_2026.domain.model.Users
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun fetchAllUsers(): Result<List<Users>>//Flow<List<Users>>
}