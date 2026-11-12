package com.example.testproject2_06_09_2026.domain.usecase

import com.example.testproject2_06_09_2026.domain.model.Users
import com.example.testproject2_06_09_2026.domain.repository.UserRepository
import javax.inject.Inject

class UserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(): Result<List<Users>> = userRepository.fetchAllUsers()
}
