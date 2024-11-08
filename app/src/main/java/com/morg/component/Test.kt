package com.morg.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.morg.component.button.ButtonComponent
import com.morg.component.textfield.TextFieldComponent
import com.morg.component.textfield.TextInputType
import com.morg.component.util.theme.BodyMedium
import com.morg.component.util.theme.ComponentSize
import com.morg.component.util.theme.ComponentType

@Preview(showBackground = true)
@Composable
fun ComponentPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.ic_group_logo),
            contentDescription = "Application Logo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )

        Text(
            text = "Masuk ke Aplikasi GroUp",
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextFieldComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            id = "txt_username",
            labelModifier = Modifier,
            textStyleLabel = BodyMedium,
            label = "Nama Pengguna",
            value = "",
            readOnly = false,
            enable = true,
            hint = "Masukkan nama pengguna/nomor ponsel",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.LARGE,
            singleLine = true,
            textInputType = TextInputType.TEXT,
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

        TextFieldComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            id = "txt_password",
            labelModifier = Modifier,
            textStyleLabel = BodyMedium,
            label = "Kata Sandi",
            value = "",
            readOnly = false,
            enable = true,
            hint = "Masukkan kata sandi",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.LARGE,
            singleLine = true,
            textInputType = TextInputType.PASSWORD,
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

        Text(
            text = "Lupa kata sandi?",
            modifier = Modifier
                .align(Alignment.End)
                .clickable { }
                .padding(end = 16.dp),
            color = Color.Red,
            fontSize = 14.sp,
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.height(8.dp))

        ButtonComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            id = "btn_login",
            label = "Masuk",
            componentSize = ComponentSize.LARGE,
            componentType = ComponentType.PRIMARY,
            componentColor = Color.Red,
            enabled = true,
            onClick = {
                // Add your logic here
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Belum punya akun? Daftar",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color.Red,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}