package com.morg.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
import com.morg.component.util.theme.ComponentSize
import com.morg.component.util.theme.ComponentType

@Preview(showBackground = true)
@Composable
fun CardComponentPreview() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.ic_group_logo),
            contentDescription = "Default Logo",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextFieldComponent(
            modifier = Modifier.fillMaxWidth(),
            id = "",
            labelModifier = Modifier,
            textStyleLabel = TextStyle.Default,
            label = "Username",
            value = "",
            readOnly = false,
            enable = true,
            hint = "Enter your Username",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.LARGE,
            singleLine = true,
            textInputType = TextInputType.NORMAL,
            suffixIconImages = Pair(null, null),
            prefixIconImages = Pair(null, null),
            prefixText = "",
            onClickIcon = {
                // Add your logic here
            },
            onTextChanged = {
                // Add your logic here
            },
            countryCodes = emptyList(),
            countryCode = "",
            onCountryCodeClick = {
                // Add your logic here
            },
            dropdownOptions = emptyList(),
            onDropdownOptionSelected = {
                // Add your logic here
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextFieldComponent(
            modifier = Modifier.fillMaxWidth(),
            id = "",
            labelModifier = Modifier,
            textStyleLabel = TextStyle.Default,
            label = "Password",
            value = "",
            readOnly = false,
            enable = true,
            hint = "Enter your password",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.LARGE,
            singleLine = true,
            textInputType = TextInputType.PASSWORD,
            suffixIconImages = Pair(null, null),
            prefixIconImages = Pair(null, null),
            prefixText = "",
            onClickIcon = {
                // Add your logic here
            },
            onTextChanged = {
                // Add your logic here
            },
            countryCodes = emptyList(),
            countryCode = "",
            onCountryCodeClick = {
                // Add your logic here
            },
            dropdownOptions = emptyList(),
            onDropdownOptionSelected = {
                // Add your logic here
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column {
            Row {
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Lupa kata sandi?",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default,
                    style = TextStyle.Default.copy(color = Color.Red, textAlign = TextAlign.End)
                )
            }
        }
        Text(
            text = "Lupa kata sandi?",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            style = TextStyle.Default.copy(color = Color.Red, textAlign = TextAlign.End)
        )
        Spacer(modifier = Modifier.height(8.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            id = "",
            label = "Login",
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
    }
}