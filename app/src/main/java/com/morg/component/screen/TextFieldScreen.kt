package com.morg.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.id.nexsoft.component.textfield.TextFieldComponent
import co.id.nexsoft.component.textfield.TextInputType
import co.id.nexsoft.component.util.theme.ComponentSize

@Preview(showBackground = true)
@Composable
fun TextFieldScreenPreview() {
    TextFieldScreen(navController = NavController(LocalContext.current))
}

@Composable
fun TextFieldScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {

            TextFieldComponent(label = "Full Name",
                value = "Hieronimus Fredy Morgan",
                labelModifier = Modifier.padding(bottom = 20.dp),
                textStyleLabel = TextStyle(fontSize = 40.sp),
                readOnly = true,
                hint = "Enter your password",
                componentSize = ComponentSize.LARGE,
                onTextChanged = { /* handle text change */ })
            Spacer(modifier = Modifier.height(5.dp))

            TextFieldComponent(label = "Full Name",
                value = "Hieronimus Fredy Morgan",
                readOnly = true,
                hint = "Enter your password",
                componentSize = ComponentSize.MEDIUM,
                onTextChanged = { /* handle text change */ })
            Spacer(modifier = Modifier.height(5.dp))

            TextFieldComponent(label = "Full Name",
                value = "Hieronimus Fredy Morgan",
                readOnly = true,
                hint = "Enter your password",
                componentSize = ComponentSize.SMALL,
                onTextChanged = { /* handle text change */ })
            Spacer(modifier = Modifier.height(5.dp))

            TextFieldComponent(label = "Password",
                value = "",
                textInputType = TextInputType.PASSWORD,
                hint = "Enter your password",
                componentSize = ComponentSize.LARGE,
                onTextChanged = { /* handle text change */ })
            Spacer(modifier = Modifier.height(5.dp))

            TextFieldComponent(label = "Password",
                value = "",
                textInputType = TextInputType.PASSWORD,
                hint = "Enter your password",
                componentSize = ComponentSize.MEDIUM,
                onTextChanged = { /* handle text change */ })
            Spacer(modifier = Modifier.height(5.dp))

            TextFieldComponent(label = "Password",
                value = "",
                textInputType = TextInputType.PASSWORD,
                hint = "Enter your password",
                componentSize = ComponentSize.SMALL,
                onTextChanged = { /* handle text change */ })
            Spacer(modifier = Modifier.height(5.dp))

            TextFieldComponent(label = "Password",
                value = "",
                hint = "Enter your password",
                prefixIconImages = Pair(Icons.Filled.Favorite, null),
                onTextChanged = { /* handle text change */ })
            Spacer(modifier = Modifier.height(5.dp))
            TextFieldComponent(label = "Phone Number",
                value = "",
                textInputType = TextInputType.PHONE,
                countryCode = "+6",
                countryCodes = listOf("+11", "+22", "+33", "+44", "+55", "+66"),
                onCountryCodeClick = { /* Handle country code selection */ },
                onTextChanged = { newText -> /* Handle text input */ })
            Spacer(modifier = Modifier.height(5.dp))

            TextFieldComponent(
                label = "Select an Option",
                value = "",
                componentSize = ComponentSize.SMALL,
                textInputType = TextInputType.DROPDOWN,
                dropdownOptions = listOf("Option 1", "Option 2", "Option 3"),
                onDropdownOptionSelected = { selected ->
                },
                hint = "Choose from the list"
            )
            Spacer(modifier = Modifier.height(5.dp))

            TextFieldComponent(
                label = "Select an Option",
                value = "",
                componentSize = ComponentSize.MEDIUM,
                textInputType = TextInputType.DROPDOWN,
                dropdownOptions = listOf("Option 1", "Option 2", "Option 3"),
                onDropdownOptionSelected = { selected ->
                },
                hint = "Choose from the list"
            )
            Spacer(modifier = Modifier.height(5.dp))

            TextFieldComponent(
                label = "Select an Option",
                value = "",
                componentSize = ComponentSize.LARGE,
                textInputType = TextInputType.DROPDOWN,
                dropdownOptions = listOf("Option 1", "Option 2", "Option 3"),
                onDropdownOptionSelected = { selected ->
                },
                hint = "Choose from the list"
            )
            Spacer(modifier = Modifier.height(5.dp))

        }
    }
}