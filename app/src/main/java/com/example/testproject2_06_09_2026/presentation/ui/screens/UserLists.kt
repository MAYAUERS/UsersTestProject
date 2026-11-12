package com.example.testproject2_06_09_2026.presentation.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testproject2_06_09_2026.domain.model.Users

@Composable
fun UserLists(user: List<Users>) {
    LazyColumn() {
        items(user){users->
            UserListsContent(users)
        }
    }
}