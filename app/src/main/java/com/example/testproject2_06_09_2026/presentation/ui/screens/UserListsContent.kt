package com.example.testproject2_06_09_2026.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testproject2_06_09_2026.domain.model.Users

@Composable
fun UserListsContent(users: Users) {

    Column() {
        Text(users.id.toString())
        Text(users.name)
        Text(users.email)
        Text(users.address.city)
        Text(users.company.name)
    }
}