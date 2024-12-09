package com.morg.component.login.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LoginScreenContent(
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onLoginClick = {
            viewModel.onLogin()
            if (uiState is LoginViewModel.LoginUiState.Success) {
                navController.navigate("dashboard/${viewModel.userId}")
            }
        },
        onForgotPasswordClick = {
            navController.navigate("forgot_password")
        }
    )
}