package com.example.testproject2_06_09_2026.presentation.ui.screens

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.testproject2_06_09_2026.domain.model.Users

@Composable
fun UserListsCard(userState: UserUiState<List<Users>>) {

    when (val user = userState) {
        is UserUiState.Loading -> {
            CircularProgressIndicator()
        }

        is UserUiState.Empty -> {
            Text("No Data")
        }

        is UserUiState.Error -> {
            Text(user.error.toAppErrorMessage())
        }

        is UserUiState.Success -> {
            UserLists(user = user.data)
        }
    }
}