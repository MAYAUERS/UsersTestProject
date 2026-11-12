package com.example.testproject2_06_09_2026.data.remote.dto

data class UserDtoItem(
    val address: AddressDto,
    val company: CompanyDto,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)