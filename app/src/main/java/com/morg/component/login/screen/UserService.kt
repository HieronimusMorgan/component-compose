package com.morg.component.login.screen

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("/api/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}

data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val success: Boolean, val error: String?)