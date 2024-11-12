package com.morg.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.stepper.StepperComponent
import co.id.nexsoft.component.util.theme.ComponentSize

@Preview(showBackground = true)
@Composable
fun StepperScreenPreview() {
    StepperScreen(navController = NavController(LocalContext.current))
}

@Composable
fun StepperScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            Text(text = "Stepper Component")
            Spacer(modifier = Modifier.padding(8.dp))
            ComponentSize.entries.forEach {
                StepperComponent(
                    initialValue = 0,
                    minValue = 0,
                    maxValue = 10000,
                    componentSize = it,
                    iconColor = Color.Black,
                    borderColor = Color.Gray,
                    onValueChange = { /* Add your logic here */ }
                )
                Spacer(modifier = Modifier.padding(16.dp))

            }
        }
    }
}