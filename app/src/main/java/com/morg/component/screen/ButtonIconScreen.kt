package com.morg.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.button.ButtonIconComponent
import co.id.nexsoft.component.util.theme.ComponentSize
import co.id.nexsoft.component.util.theme.ComponentType

@Preview(showBackground = true)
@Composable
fun ButtonIconScreenPreview() {
    ButtonIconScreen(navController = NavController(LocalContext.current))
}

@Composable
fun ButtonIconScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            Text(text = "Button Icon Primary")
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                ComponentSize.entries.forEach { size ->
                    ButtonIconComponent(
                        componentSize = size,
                        componentType = ComponentType.PRIMARY,
                        icon = Icons.Default.Add,
                        iconColor = Color.White
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Button Icon Secondary")
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                ComponentSize.entries.forEach { size ->
                    ButtonIconComponent(
                        componentSize = size,
                        componentType = ComponentType.SECONDARY,
                        icon = Icons.Default.Add,
                        iconColor = Color.Black,
                        componentColor = Color.Black
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Button Icon Tertiary")
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                ComponentSize.entries.forEach { size ->
                    ButtonIconComponent(
                        componentSize = size,
                        componentType = ComponentType.TERTIARY,
                        icon = Icons.Default.Add,
                        iconColor = Color.Black,
                        componentColor = Color.Black
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}