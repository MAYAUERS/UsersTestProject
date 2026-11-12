package com.example.testproject2_06_09_2026.presentation.ui.screens


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.testproject2_06_09_2026.presentation.viewmodel.UserViewmodel

@Composable
fun UserListScreen(vm: UserViewmodel = hiltViewModel()) {

    val userState by vm.uiState.collectAsStateWithLifecycle()
    UserListsCard(userState = userState)
}

