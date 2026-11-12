package com.example.testproject2_06_09_2026.domain.model



data class Users(
    val id: Int,
    val name: String,
    val address: Address,
    val company: Company,
    val email: String,
)

data class Address(  val city: String)

data class Company(val name: String)