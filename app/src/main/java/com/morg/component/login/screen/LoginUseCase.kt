package com.morg.component.login.screen

import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend fun execute(username: String, password: String): Result<LoginResponse> {
        return if (validateInput(username, password)) {
            repository.authenticateUser(username, password)
        } else {
            Result.failure(Exception("Invalid input"))
        }
    }

    private fun validateInput(username: String, password: String): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }
}