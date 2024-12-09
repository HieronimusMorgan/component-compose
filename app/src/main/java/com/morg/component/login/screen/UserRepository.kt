package com.morg.component.login.screen

import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: UserService
) {
    suspend fun authenticateUser(username: String, password: String): Result<LoginResponse> {
        return try {
            val response = userService.login(LoginRequest(username, password))
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Authentication failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}