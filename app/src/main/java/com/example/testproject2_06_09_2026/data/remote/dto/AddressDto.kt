package com.example.testproject2_06_09_2026.data.remote.dto

data class AddressDto(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)