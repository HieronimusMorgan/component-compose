package com.morg.component.login.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.id.nexsoft.component.button.ButtonComponent
import co.id.nexsoft.component.textfield.TextFieldComponent
import co.id.nexsoft.component.util.theme.CaptionSmall
import co.id.nexsoft.component.util.theme.Heading1

@Composable
fun LoginScreenContent(
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome Back",
            style = Heading1,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextFieldComponent(
            hint = "Email Address",
            onTextChanged = onEmailChange,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextFieldComponent(
            hint = "Password",
            onTextChanged = onPasswordChange,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        ButtonComponent(
            label = "Login",
            onClick = onLoginClick,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Forgot Password?",
            style = CaptionSmall,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable(onClick = onForgotPasswordClick)
        )
    }
}