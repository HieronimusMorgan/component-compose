package com.morg.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import co.id.nexsoft.component.button.ButtonComponent
import co.id.nexsoft.component.textfield.TextFieldComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Retrofit
import retrofit2.http.Field
import retrofit2.http.POST
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {
    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState

    fun onEmailChange(newEmail: String) {
        _loginState.value = _loginState.value.copy(email = newEmail)
    }

    fun onPasswordChange(newPassword: String) {
        _loginState.value = _loginState.value.copy(password = newPassword)
    }

    fun onLogin() {
        if (_loginState.value.email.isEmpty() || _loginState.value.password.isEmpty()) {
            _loginState.value = _loginState.value.copy(errorMessage = "Please fill in all fields")
        } else {
            _loginState.value = _loginState.value.copy(errorMessage = "")
            // Proceed with authentication logic using repository
        }
    }

    data class LoginState(
        val email: String = "",
        val password: String = "",
        val errorMessage: String = ""
    )
}

@Composable
fun LoginScreenContent(
    loginViewModel: LoginViewModel,
) {
    val loginState by loginViewModel.loginState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextFieldComponent(
            value = loginState.email,
            onTextChanged = { loginViewModel.onEmailChange(it) },
            label = "Email Address",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        )
        TextFieldComponent(
            value = loginState.password,
            onTextChanged = { loginViewModel.onPasswordChange(it) },
            label = "Password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        )
        ButtonComponent(
            onClick = { loginViewModel.onLogin() },
            label = "Login",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
        )
        if (loginState.errorMessage.isNotEmpty()) {
            Text(
                text = loginState.errorMessage,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {
    LoginScreenContent(loginViewModel = viewModel)
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreenContent(
        loginViewModel = LoginViewModel(LoginRepository(object : LoginService {
            override suspend fun login(email: String, password: String): Boolean {
                return true
            }
        }))
    )
}

class LoginRepository @Inject constructor(
    private val service: LoginService
) {
    suspend fun authenticate(email: String, password: String): Boolean {
        // Implement authentication logic using the service
        return service.login(email, password)
    }
}


interface LoginService {
    @POST("auth/login")
    suspend fun login(@Field("email") email: String, @Field("password") password: String): Boolean
}


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    fun provideLoginService(retrofit: Retrofit): LoginService {
        return retrofit.create(LoginService::class.java)
    }

    @Provides
    fun provideLoginRepository(service: LoginService): LoginRepository {
        return LoginRepository(service)
    }
}
