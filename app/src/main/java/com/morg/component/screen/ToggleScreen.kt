package com.morg.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.toggle.ToggleComponent
import co.id.nexsoft.component.util.theme.ComponentSize

@Preview(showBackground = true)
@Composable
fun ToggleScreenPreview() {
    ToggleScreen(navController = NavController(LocalContext.current))
}

@Composable
fun ToggleScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var isToggled by remember { mutableStateOf(false) }

        Column {
            Text(text = "Toggle Default")
            Spacer(modifier = Modifier.padding(8.dp))
            ComponentSize.entries.forEach {
                ToggleComponent(
                    isChecked = isToggled,
                    componentSize = it,
                    onCheckedChange = { isToggled = it },
                    onColor = Color.Green,
                    offColor = Color.Gray,
                    thumbColor = Color.White
                )
                Spacer(modifier = Modifier.padding(8.dp))

            }
            Spacer(modifier = Modifier.padding(16.dp))
            Text(text = "Toggle Label Default")
            Spacer(modifier = Modifier.padding(8.dp))
            ComponentSize.entries.forEach {
                ToggleComponent(
                    isChecked = isToggled,
                    title = "Toggle Component",
                    componentSize = it,
                    onCheckedChange = { isToggled = it },
                    onColor = Color.Green,
                    offColor = Color.Gray,
                    thumbColor = Color.White
                )
                Spacer(modifier = Modifier.padding(8.dp))

            }
            Spacer(modifier = Modifier.padding(16.dp))
            Text(text = "Toggle Label Information Default")
            Spacer(modifier = Modifier.padding(8.dp))
            ComponentSize.entries.forEach {
                ToggleComponent(
                    isChecked = isToggled,
                    title = "Toggle Component",
                    informationText = "Information Text",
                    componentSize = it,
                    onCheckedChange = { isToggled = it },
                    onColor = Color.Green,
                    offColor = Color.Gray,
                    thumbColor = Color.White
                )
                Spacer(modifier = Modifier.padding(8.dp))

            }
            Spacer(modifier = Modifier.padding(16.dp))
            Text(text = "Toggle Label Error Default")
            Spacer(modifier = Modifier.padding(8.dp))
            ComponentSize.entries.forEach {
                ToggleComponent(
                    isChecked = isToggled,
                    title = "Toggle Component",
                    errorText = "Error Text",
                    componentSize = it,
                    onCheckedChange = { isToggled = it },
                    onColor = Color.Green,
                    offColor = Color.Gray,
                    thumbColor = Color.White
                )
                Spacer(modifier = Modifier.padding(8.dp))

            }
            Spacer(modifier = Modifier.padding(16.dp))
        }
    }
}