import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val service: LoginService,
    private val dao: LoginDao
) {
    suspend fun login(email: String, password: String): User {
        // Logic to interact with service and dao
        return service.login(LoginRequest(email, password)).user
    }
}