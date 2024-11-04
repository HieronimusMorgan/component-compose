package com.morg.component.otp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.morg.component.util.theme.BodyMedium

@Preview(showBackground = true)
@Composable
fun OtpScreenPreview() {
    OtpVerification(otpLength = 6, isPassword = true) { otp ->
        println("Complete OTP: $otp")
    }
}

/**
 *The OtpVerification function in Kotlin is a composable function that creates an OTP (One-Time Password) verification input field using Jetpack Compose. This function displays a row of text fields for the user to enter an OTP code.
 *
 * The function accepts several parameters, including modifier, textStyle, width, otpLength, isPassword, and onOtpComplete. The modifier parameter allows customization of the row of text fields, while textStyle specifies the style to be applied to each text field. The width parameter sets the width of each text field, and otpLength determines the length of the OTP code. The isPassword parameter indicates whether the OTP input should be masked as a password, and onOtpComplete is a callback function that is invoked when the OTP input is complete.
 *
 * Inside the function, two state variables are defined using remember: otpValues and focusRequesters. otpValues is a list that holds the current values of the OTP input fields, and focusRequesters is a list of FocusRequester objects used to manage focus between the text fields:
 * ``` kotlin
 * val otpValues = remember { mutableStateListOf(*Array(otpLength) { "" }) }
 * val focusRequesters = List(otpLength) { FocusRequester() }
 * ```
 *
 * The Row composable arranges the text fields horizontally with a specified spacing. Each text field is created using OutlinedTextField, and its value is managed by otpValues. The onValueChange lambda updates the corresponding value in otpValues and manages focus transitions between fields. If the last field is filled, the onOtpComplete callback is invoked with the complete OTP:
 * ``` kotlin
 * OutlinedTextField(
 *     value = value,
 *     onValueChange = { newValue ->
 *         if (newValue.length <= 1) {
 *             otpValues[index] = newValue
 *             if (newValue.isNotEmpty() && index < otpLength - 1) {
 *                 focusRequesters[index + 1].requestFocus()
 *             } else if (index == otpLength - 1) {
 *                 onOtpComplete(otpValues.joinToString(""))
 *             }
 *         }
 *     },
 *     keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
 *     visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
 *     singleLine = true,
 *     modifier = Modifier
 *         .width(width)
 *         .focusRequester(focusRequesters[index])
 *         .onFocusChanged { if (it.isFocused && value.isNotEmpty()) otpValues[index] = "" },
 *     textStyle = textStyle.copy(textAlign = TextAlign.Center)
 * )
 * ```
 * Finally, a LaunchedEffect is used to request focus on the first text field when the composable is first displayed:
 * ``` kotlin
 * LaunchedEffect(Unit) {
 *     focusRequesters.first().requestFocus()
 * }
 * ```
 * @param modifier The modifier to be applied to the row of text fields.
 * @param textStyle The text style to be applied to each text field.
 * @param width The width of each text field.
 * @param otpLength The length of the OTP code.
 * @param isPassword Whether the OTP input should be masked as a password.
 * @param onOtpComplete The callback to be invoked when the OTP input is complete.
 */
@Composable
fun OtpVerification(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = BodyMedium,
    width: Dp = 48.dp,
    otpLength: Int = 6,
    isPassword: Boolean = false,
    onOtpComplete: (String) -> Unit
) {
    val otpValues = remember { mutableStateListOf(*Array(otpLength) { "" }) }
    val focusRequesters = List(otpLength) { FocusRequester() }

    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        otpValues.forEachIndexed { index, value ->
            OutlinedTextField(
                value = value,
                onValueChange = { newValue ->
                    if (newValue.length <= 1) {
                        otpValues[index] = newValue
                        if (newValue.isNotEmpty() && index < otpLength - 1) {
                            focusRequesters[index + 1].requestFocus()
                        } else if (index == otpLength - 1) {
                            onOtpComplete(otpValues.joinToString(""))
                        }
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
                singleLine = true,
                modifier = Modifier
                    .width(width)
                    .focusRequester(focusRequesters[index])
                    .onFocusChanged {
                        if (it.isFocused && value.isNotEmpty()) otpValues[index] = ""
                    },
                textStyle = textStyle.copy(textAlign = TextAlign.Center)
            )
        }
    }

    LaunchedEffect(Unit) {
        focusRequesters.first().requestFocus()
    }
}

