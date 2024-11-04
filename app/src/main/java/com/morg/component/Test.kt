package com.morg.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.morg.component.button.ButtonComponent
import com.morg.component.textfield.TextFieldComponent
import com.morg.component.textfield.TextInputType
import com.morg.component.util.theme.BodyLarge
import com.morg.component.util.theme.ComponentSize
import com.morg.component.util.theme.ComponentType

@Preview(showBackground = true)
@Composable
fun CardComponentPreview() {
    Column {

        Image(
            painter = painterResource(id = R.drawable.ic_group_logo),
            contentDescription = "App Logo",
            modifier = Modifier.fillMaxWidth()
        )

        TextFieldComponent(
            modifier = Modifier.fillMaxWidth(),
            id = "",
            label = "Full Name",
            value = "",
            hint = "Enter your full name",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.LARGE,
            singleLine = true,
            textInputType = TextInputType.NORMAL,
            dropdownOptions = emptyList(),
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextFieldComponent(
            modifier = Modifier.fillMaxWidth(),
            id = "",
            label = "Email",
            value = "",
            hint = "Enter your email",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.LARGE,
            singleLine = true,
            textInputType = TextInputType.NORMAL,
            dropdownOptions = emptyList(),
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextFieldComponent(
            modifier = Modifier.fillMaxWidth(),
            id = "",
            label = "Username",
            value = "",
            hint = "Choose a username",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.LARGE,
            singleLine = true,
            textInputType = TextInputType.NORMAL,
            dropdownOptions = emptyList(),
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextFieldComponent(
            modifier = Modifier.fillMaxWidth(),
            id = "",
            label = "Phone Number",
            value = "",
            hint = "Enter your phone number",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.LARGE,
            singleLine = true,
            textInputType = TextInputType.PHONE,
            prefixText = "",
            countryCodes = listOf("+11", "+22", "+33", "+44", "+55", "+66"),
            countryCode = "+6",
            dropdownOptions = emptyList(),
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextFieldComponent(
            modifier = Modifier.fillMaxWidth(),
            id = "",
            label = "Password",
            value = "",
            hint = "Create a password",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.LARGE,
            singleLine = true,
            textInputType = TextInputType.PASSWORD,
            dropdownOptions = emptyList(),
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextFieldComponent(
            modifier = Modifier.fillMaxWidth(),
            id = "",
            label = "Confirm Password",
            value = "",
            hint = "Confirm your password",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.LARGE,
            singleLine = true,
            textInputType = TextInputType.PASSWORD,
            dropdownOptions = emptyList(),
        )

        Spacer(modifier = Modifier.height(8.dp))

        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            id = "",
            label = "Register",
            componentSize = ComponentSize.MEDIUM,
            componentType = ComponentType.PRIMARY,
            componentColor = Color.Red,
            drawableStart = null,
            drawableEnd = null,
            underline = false,
            enabled = true,
            onClick = {
                // Add your logic here
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Already have an account? Login",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            style = BodyLarge,
            color = Color.Blue,
            textAlign = TextAlign.Center,
        )
    }
}