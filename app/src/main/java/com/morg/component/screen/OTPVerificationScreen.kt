package com.morg.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.otp.OtpVerification
import co.id.nexsoft.component.util.theme.BodyMedium

@Preview(showBackground = true)
@Composable
fun OtpVerificationPreview() {
    OTPVerificationScreen(navController = NavController(LocalContext.current))
}

@Composable
fun OTPVerificationScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            OtpVerification(
                modifier = Modifier,
                textStyle = BodyMedium,
                width = 48.dp,
                otpLength = 6,
                isPassword = true
            ) { otp ->
                println("Complete OTP: $otp")
            }
        }
    }
}