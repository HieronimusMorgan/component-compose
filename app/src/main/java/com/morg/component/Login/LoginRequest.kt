data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val user: User,
    val token: String
)

data class User(
    val id: Int,
    val email: String,
    val name: String
)