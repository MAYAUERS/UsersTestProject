package com.example.testproject2_06_09_2026.data.repository

import com.example.testproject2_06_09_2026.data.remote.mapper.toDomain
import com.example.testproject2_06_09_2026.data.remote.service.UserApiService
import com.example.testproject2_06_09_2026.domain.model.Users
import com.example.testproject2_06_09_2026.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: UserApiService) :
    UserRepository {

    /* override suspend fun fetchAllUsers(): Flow<List<Users>> = flow {
        val response = apiService.getAllUsers()
        val dtoToDomain = response.map { it.toDomain() }
        emit(dtoToDomain)
    }.flowOn(Dispatchers.IO)*/
    override suspend fun fetchAllUsers(): Result<List<Users>> {
        return runCatching {
            apiService.getAllUsers().map { it.toDomain() }
        }
    }
}