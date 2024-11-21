package com.morg.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import co.id.nexsoft.component.button.ButtonComponent
import co.id.nexsoft.component.textfield.TextFieldComponent
import co.id.nexsoft.component.textfield.TextInputType
import co.id.nexsoft.component.util.theme.BodyMedium
import co.id.nexsoft.component.util.theme.ComponentSize
import co.id.nexsoft.component.util.theme.ComponentType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage(viewModel = LoginViewModel())
}

@Composable
fun LoginPage(viewModel: LoginViewModel) {
    val username by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_group_logo),
            contentDescription = "Login page branding image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            colorFilter = ColorFilter.tint(color = Color(0XFFAEB4B7))
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextFieldComponent(
            modifier = Modifier.fillMaxWidth(0.8f),
            id = "username_input",
            labelModifier = Modifier,
            textStyleLabel = BodyMedium,
            label = "Username",
            value = username,
            readOnly = false,
            enable = true,
            hint = "",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.MEDIUM,
            singleLine = true,
            textInputType = TextInputType.TEXT,
            suffixIconImages = null,
            prefixIconImages = null,
            prefixText = "",
            onClickIcon = { /* Add your logic here */ },
            onTextChanged = { viewModel.onUsernameChanged(it) },
            countryCodes = emptyList(),
            countryCode = "+62",
            onCountryCodeClick = { /* Add your logic here */ },
            dropdownOptions = emptyList(),
            onDropdownOptionSelected = { /* Add your logic here */ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextFieldComponent(
            modifier = Modifier.fillMaxWidth(0.8f),
            id = "password_input",
            labelModifier = Modifier,
            textStyleLabel = BodyMedium,
            label = "Password",
            value = password,
            readOnly = false,
            enable = true,
            hint = "",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.MEDIUM,
            singleLine = true,
            textInputType = TextInputType.PASSWORD,
            suffixIconImages = null,
            prefixIconImages = null,
            prefixText = "",
            onClickIcon = { /* Add your logic here */ },
            onTextChanged = { viewModel.onPasswordChanged(it) },
            countryCodes = emptyList(),
            countryCode = "+62",
            onCountryCodeClick = { /* Add your logic here */ },
            dropdownOptions = emptyList(),
            onDropdownOptionSelected = { /* Add your logic here */ }
        )

        Spacer(modifier = Modifier.height(24.dp))

        ButtonComponent(
            modifier = Modifier.fillMaxWidth(0.6f),
            id = "login_button",
            label = "Login",
            componentSize = ComponentSize.MEDIUM,
            componentType = ComponentType.PRIMARY,
            componentColor = MaterialTheme.colorScheme.primary,
            drawableStart = null,
            drawableEnd = null,
            underline = false,
            enabled = true,
            onClick = { viewModel.onLoginClicked() }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Forgot Password?",
            modifier = Modifier,
            color = Color.Unspecified,
            fontSize = 16.sp,
            style = LocalTextStyle.current
        )
    }
}

class LoginViewModel : ViewModel() {
    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    fun onUsernameChanged(newUsername: String) {
        _username.value = newUsername
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    fun onLoginClicked() {
        // Handle login logic
    }
}

class LoginRepository {
    // Handle data operations, API calls, or database interactions
}