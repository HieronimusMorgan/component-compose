package com.morg.component
// auto import missing library

// additional library must be imported
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.morg.component.button.ButtonComponent
import com.morg.component.textfield.TextFieldComponent
import com.morg.component.util.theme.BodyMedium
import com.morg.component.util.theme.ComponentSize
import com.morg.component.util.theme.ComponentType

@Preview(showBackground = true)
@Composable
fun CardComponentPreview() {
    Column {
        Text(
            text = "Forgot Password",
            modifier = Modifier,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            style = LocalTextStyle.current
        )

        TextFieldComponent(
            modifier = Modifier,
            id = "txt_email",
            labelModifier = Modifier,
            textStyleLabel = BodyMedium,
            label = "Email Address",
            value = "",
            readOnly = false,
            enable = true,
            hint = "Enter your email",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.LARGE,
            singleLine = true,
//            textInputType = TextInputType.Email,
            prefixText = null,
            onClickIcon = {
                // Add your logic here
            },
            onTextChanged = {
                // Add your logic here
            },
            countryCodes = emptyList(),
            countryCode = "+62",
            onCountryCodeClick = {
                // Add your logic here
            },
            dropdownOptions = emptyList(),
            onDropdownOptionSelected = {
                // Add your logic here
            }
        )

        ButtonComponent(
            modifier = Modifier,
            id = "btn_reset_password",
            label = "Reset Password",
            componentSize = ComponentSize.MEDIUM,
            componentType = ComponentType.PRIMARY,
            componentColor = MaterialTheme.colorScheme.primary,
            underline = false,
            enabled = true,
            onClick = {
                // Add your logic here
            }
        )

        Text(
            text = "Remembered your password? Log in",
            modifier = Modifier,
            color = Color.Gray,
            textDecoration = TextDecoration.LineThrough,
            textAlign = TextAlign.Center,
            style = LocalTextStyle.current
        )
    }
}