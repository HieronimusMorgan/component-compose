import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {
    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState

    fun onEmailChanged(newEmail: String) {
        _loginState.value = _loginState.value.copy(email = newEmail)
    }

    fun onPasswordChanged(newPassword: String) {
        _loginState.value = _loginState.value.copy(password = newPassword)
    }

    fun onRememberMeChanged(isChecked: Boolean) {
        _loginState.value = _loginState.value.copy(rememberMe = isChecked)
    }

    fun onLogin() {
        // Handle login logic, possibly using repository
        viewModelScope.launch {
            val user = repository.login(_loginState.value.email, _loginState.value.password)
            // Handle user login response
        }
    }

    data class LoginState(
        val email: String = "",
        val password: String = "",
        val rememberMe: Boolean = false
    )
}