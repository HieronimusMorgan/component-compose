package com.morg.component.login.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var userId: Int = 0

    fun onEmailChange(newEmail: String) {
        email = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        password = newPassword
    }

    fun onLogin() {
        viewModelScope.launch {
            _uiState.value = LoginUiState.Loading
            try {
                val result = loginUseCase.execute(email, password)
                if (result.isSuccess) {
                    _uiState.value = LoginUiState.Success
                    userId = 1 // Assuming the user ID is obtained after login
                } else {
                    _uiState.value =
                        LoginUiState.Error(result.exceptionOrNull()?.message ?: "Unknown error")
                }
            } catch (e: Exception) {
                _uiState.value = LoginUiState.Error("An unexpected error occurred.")
            }
        }
    }

    sealed class LoginUiState {
        object Idle : LoginUiState()
        object Loading : LoginUiState()
        object Success : LoginUiState()
        data class Error(val message: String) : LoginUiState()
    }
}