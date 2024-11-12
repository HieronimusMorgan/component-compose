package com.morg.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.steps.StepComponent

@Preview(showBackground = true)
@Composable
fun StepComponentPreview() {
    StepScreen(navController = NavController(context = LocalContext.current))
}

@Composable
fun StepScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            StepComponent(
                totalSteps = 4, currentStep = 0,
                steps = listOf("Step 1", "Step 2", "Step 3", "Step 4"), isVertical = false
            )
            StepComponent(
                totalSteps = 4, currentStep = 0,
                steps = listOf("Step 1", "Step 2", "Step 3", "Step 4"), isVertical = true
            )
        }
    }
}