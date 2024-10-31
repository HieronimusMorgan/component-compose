package com.morg.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.morg.component.button.ButtonComponent
import com.morg.component.textfield.TextFieldComponent
import com.morg.component.util.theme.BodyLarge
import com.morg.component.util.theme.ComponentSize

@Preview(showBackground = true)
@Composable
fun CardComponentPreview() {
    Column {
        Text(text = "Username")
        TextFieldComponent(
            label = "Username",
            textStyleLabel = BodyLarge,
            value = "",
            componentSize = ComponentSize.LARGE,
            hint = "enter your username",
            onTextChanged = { /* handle text change */ }
        )
        Text(text = "Password")
        TextFieldComponent(
            label = "Password",
            textStyleLabel = BodyLarge,
            value = "",
            componentSize = ComponentSize.LARGE,
            hint = "enter your password",
            onTextChanged = { /* handle text change */ }
        )
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Login",
            componentSize = ComponentSize.MEDIUM
        )
    }
}