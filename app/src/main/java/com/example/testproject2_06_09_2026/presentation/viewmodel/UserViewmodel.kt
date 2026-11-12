package com.example.testproject2_06_09_2026.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject2_06_09_2026.data.errormapper.ErrorMapper
import com.example.testproject2_06_09_2026.domain.model.Users
import com.example.testproject2_06_09_2026.domain.usecase.UserUseCase
import com.example.testproject2_06_09_2026.presentation.ui.screens.UserUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewmodel @Inject constructor(
    private val userUseCase: UserUseCase,
    private val errorMapper: ErrorMapper
) : ViewModel() {

    /* val uiState: StateFlow<UserUiState<List<Users>>> = flow<UserUiState<List<Users>>> {
         emit(UserUiState.Loading)
         userUseCase().fold(
             onSuccess = { users ->
                 if (users.isEmpty()) emit(UserUiState.Empty)
                 else emit(UserUiState.Success(users))
             },
             onFailure = { emit(UserUiState.Error(it)) }
         )
     }.stateIn(
         viewModelScope,
         started = SharingStarted.WhileSubscribed(5000),
         initialValue = UserUiState.Loading
     )*/

    private val _uiState = MutableStateFlow<UserUiState<List<Users>>>(UserUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadUsers()
    }

    fun loadUsers() {
        viewModelScope.launch {
            _uiState.value = UserUiState.Loading

            userUseCase()
                .onSuccess { users ->
                    if (users.isEmpty()) {
                        _uiState.value = UserUiState.Empty
                    } else {
                        _uiState.value = UserUiState.Success(users)
                    }
                }
                .onFailure { e ->
                    if (e is CancellationException) {
                        throw e
                    } else {
                        val message =errorMapper.map(e)
                            _uiState.value = UserUiState.Error(message)
                    }
                }
        }
    }
}