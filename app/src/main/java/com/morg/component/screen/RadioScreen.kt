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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.radio.RadioButtonComponent
import co.id.nexsoft.component.util.theme.ComponentSize

@Preview(showBackground = true)
@Composable
fun RadioScreenPreview() {
    RadioScreen(navController = NavController(LocalContext.current))
}

@Composable
fun RadioScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            val options = mapOf(
                "option1" to "Option 1",
                "option2" to "Option 2",
                "option3" to "Option 3"
            )
            Text(text = "Radio Component Horizontal")
            Spacer(modifier = Modifier.padding(8.dp))
            ComponentSize.entries.forEach {
                RadioButtonComponent(
                    title = "Radio Component",
                    options = options,
                    componentSize = it,
                    onOptionSelected = {
                        // Handle the selected key
                    }
                )
                Spacer(modifier = Modifier.padding(16.dp))

            }
            Spacer(modifier = Modifier.padding(16.dp))

            Text(text = "Radio Component Horizontal")
            Spacer(modifier = Modifier.padding(8.dp))
            ComponentSize.entries.forEach {
                RadioButtonComponent(
                    title = "Radio Component",
                    options = options,
                    verticalAlignment = true,
                    componentSize = it,
                    onOptionSelected = {
                        // Handle the selected key
                    }
                )
                Spacer(modifier = Modifier.padding(16.dp))

            }
        }
    }
}