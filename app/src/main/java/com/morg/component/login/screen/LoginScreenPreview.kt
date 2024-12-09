package com.morg.component.login.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreenContent(
        onEmailChange = {},
        onPasswordChange = {},
        onLoginClick = {},
        onForgotPasswordClick = {}
    )
}