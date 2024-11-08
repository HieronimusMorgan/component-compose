package co.id.nexsoft.component.steps

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.id.nexsoft.component.util.theme.colorTextSuccess

@Preview(showBackground = true)
@Composable
fun StepIndicatorPreview() {
    Column {
        StepComponent(
            totalSteps = 4, currentStep = 0,
            steps = listOf("Step 1", "Step 2", "Step 3", "Step 4"), isVertical = false
        )
    }
}

@Composable
fun StepComponent(
    totalSteps: Int,
    currentStep: Int,
    steps: List<String> = emptyList(),
    isVertical: Boolean = false
) {
    if (isVertical) {
        VerticalStepIndicator(totalSteps, currentStep)
    } else {
        HorizontalStepIndicator(totalSteps, currentStep, steps)
    }

}

@Composable
fun HorizontalStepIndicator(totalSteps: Int, currentStep: Int, steps: List<String>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        for (index in 0 until totalSteps) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.weight(1f),
            ) {
                Row(
                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    StepCircle(
                        text = steps.getOrNull(index) ?: "",
                        isCompleted = index < currentStep,
                        isActive = index == currentStep
                    )
                    if (index < totalSteps - 1) {
                        StepDivider(
                            modifier = Modifier.weight(1f),
                            isCompleted = index < currentStep
                        )
                    }
                }
                Text(
                    steps.getOrNull(index) ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun VerticalStepIndicator(totalSteps: Int, currentStep: Int, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(vertical = 16.dp, horizontal = 8.dp)
    ) {
        for (index in 0 until totalSteps) {
            StepCircle(
                isCompleted = index < currentStep,
                isActive = index == currentStep
            )
            if (index < totalSteps - 1) {
                StepDivider(
                    modifier = Modifier.weight(1f),
                    isCompleted = index < currentStep,
                    isVertical = true
                )
            }
        }
    }
}

@Composable
fun StepCircle(text: String = "", isCompleted: Boolean, isActive: Boolean) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(24.dp)
            .background(
                color = when {
                    isCompleted -> Color(colorTextSuccess.value)
                    isActive -> Color.Transparent
                    else -> Color.LightGray
                },
                shape = CircleShape
            )
            .border(
                width = if (isActive) 2.dp else 0.dp,
                color = if (isActive) Color(colorTextSuccess.value) else Color.Transparent,
                shape = CircleShape
            )
    ) {
        if (isCompleted) {
            Text("✓", color = Color.White, fontSize = 16.sp)
        } else if (isActive) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(Color(colorTextSuccess.value), CircleShape)
            )
        }
    }
}

@Composable
fun StepDivider(modifier: Modifier, isCompleted: Boolean, isVertical: Boolean = false) {
    if (isVertical) {
        VerticalDivider(
            color = if (isCompleted) Color(colorTextSuccess.value) else Color.LightGray,
            thickness = 2.dp,
            modifier = modifier.padding(horizontal = 4.dp)
        )
    } else {
        HorizontalDivider(
            color = if (isCompleted) Color(colorTextSuccess.value) else Color.LightGray,
            thickness = 2.dp,
            modifier = modifier.padding(horizontal = 8.dp)
        )
    }
}