package com.morg.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.morg.component.button.ButtonComponent
import com.morg.component.textfield.TextFieldComponent
import com.morg.component.textfield.TextInputType
import com.morg.component.util.theme.BodyLarge
import com.morg.component.util.theme.ComponentSize
import com.morg.component.util.theme.ComponentTheme
import com.morg.component.util.theme.ComponentType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentTheme(darkTheme = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        Greeting()
                    }
                }
            }
        }
    }
}


@Composable
fun Login(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(90.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_group_logo),
            contentDescription = "App logo",
            modifier = Modifier.fillMaxWidth() // Adjust size and alignment as needed
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Masuk ke Aplikasi GroUp",
            style = BodyLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextFieldComponent(
            label = "Nama Pengguna",
            value = "",
            hint = "Masukkan nama pengguna/nomor ponsel",
            componentSize = ComponentSize.LARGE,
            onTextChanged = { /* handle text change */ }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextFieldComponent(
            label = "Kata Sandi",
            value = "",
            hint = "Masukkan kata sandi",
            textInputType = TextInputType.PASSWORD,
            componentSize = ComponentSize.LARGE,
            onTextChanged = { /* handle text change */ }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.clickable { },
                text = "Lupa kata sandi?",
                style = BodyLarge,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Masuk",
            componentColor = Color.Red,
            componentSize = ComponentSize.LARGE
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.clickable { },
                text = "Belum punya akun? Daftar",
                style = BodyLarge,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ComponentTheme {
        Scaffold {
            Login(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Button Component Medium")
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentSize = ComponentSize.MEDIUM
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentType = ComponentType.SECONDARY,
            componentSize = ComponentSize.MEDIUM
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentType = ComponentType.TERTIARY,
            componentSize = ComponentSize.MEDIUM
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "Button Component Small")
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentSize = ComponentSize.SMALL
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentType = ComponentType.SECONDARY,
            componentSize = ComponentSize.SMALL
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentType = ComponentType.TERTIARY,
            componentSize = ComponentSize.SMALL
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "Button Component Large")
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            underline = true,
            componentSize = ComponentSize.LARGE
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentType = ComponentType.SECONDARY,
            componentSize = ComponentSize.LARGE
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentType = ComponentType.TERTIARY,
            componentSize = ComponentSize.LARGE,
        )
        Spacer(modifier = Modifier.height(5.dp))

        TextFieldComponent(label = "Full Name",
            value = "Hieronimus Fredy Morgan",
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
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComponentTheme {
        Greeting()
    }
}

