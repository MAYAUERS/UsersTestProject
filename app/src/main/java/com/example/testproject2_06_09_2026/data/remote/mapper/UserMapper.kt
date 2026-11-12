package com.example.testproject2_06_09_2026.data.remote.mapper

import com.example.testproject2_06_09_2026.data.remote.dto.AddressDto
import com.example.testproject2_06_09_2026.data.remote.dto.CompanyDto
import com.example.testproject2_06_09_2026.data.remote.dto.UserDtoItem
import com.example.testproject2_06_09_2026.domain.model.Address
import com.example.testproject2_06_09_2026.domain.model.Company
import com.example.testproject2_06_09_2026.domain.model.Users

fun UserDtoItem.toDomain(): Users {
    return Users(
        id = this.id,
        name = this.name,
        address = this.address.toDomain(),
        company = this.company.toDomain(),
        email = this.email
    )
}

fun AddressDto.toDomain(): Address {
    return Address(city = this.city)
}

fun CompanyDto.toDomain(): Company {
    return Company(name = this.name)
}