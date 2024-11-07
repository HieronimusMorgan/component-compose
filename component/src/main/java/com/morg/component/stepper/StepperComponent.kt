package com.morg.component.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.morg.component.util.theme.ComponentSize

@Preview(showBackground = true)
@Composable
fun RoundedInputStepperPreview() {
    RoundedInputStepper()
}

@Composable
fun RoundedInputStepper(
    initialValue: Int = 10,
    minValue: Int = 0,
    maxValue: Int = 10000,
    size: ComponentSize = ComponentSize.MEDIUM
) {
    var value by remember { mutableIntStateOf(initialValue) }
    var textValue by remember { mutableStateOf(TextFieldValue(value.toString())) }

    // Define dimensions based on the ComponentSize
    val dimensions = when (size) {
        ComponentSize.SMALL -> StepperDimensions(77.dp, 24.dp, 24.dp, 12.sp)
        ComponentSize.MEDIUM -> StepperDimensions(88.dp, 28.dp, 28.dp, 14.sp)
        ComponentSize.LARGE -> StepperDimensions(102.dp, 32.dp, 32.dp, 16.sp)
    }

    Row(
        modifier = Modifier
            .background(Color.LightGray.copy(alpha = 0.2f), shape = RoundedCornerShape(16.dp))
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .width(dimensions.width)
            .height(dimensions.height),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Decrement Button
        IconButton(
            onClick = {
                if (value > minValue) {
                    value -= 1
                    textValue = TextFieldValue(value.toString())
                }
            },
            enabled = value > minValue,
            modifier = Modifier
                .size(dimensions.iconSize)
                .border(2.dp, Color.Blue, CircleShape)
                .background(Color.Transparent, CircleShape)
        ) {
            Text("-", color = Color.Blue, fontSize = dimensions.textSize)
        }

        // Editable Text Field
        TextField(
            value = textValue,
            onValueChange = {
                val newValue = it.text.toIntOrNull()
                if (newValue != null && newValue in minValue..maxValue) {
                    value = newValue
                    textValue = it
                } else if (it.text.isEmpty()) {
                    textValue = it
                }
            },
            modifier = Modifier.wrapContentWidth(),
            textStyle = TextStyle(textAlign = TextAlign.Center, fontSize = dimensions.textSize),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = Color.Transparent
            )
        )

        // Increment Button
        IconButton(
            onClick = {
                if (value < maxValue) {
                    value += 1
                    textValue = TextFieldValue(value.toString())
                }
            },
            enabled = value < maxValue,
            modifier = Modifier
                .size(dimensions.iconSize)
                .border(2.dp, Color.Blue, CircleShape)
                .background(Color.Transparent, CircleShape)
        ) {
            Text("+", color = Color.Blue, fontSize = dimensions.textSize)
        }
    }
}

data class StepperDimensions(
    val width: Dp,
    val height: Dp,
    val iconSize: Dp,
    val textSize: TextUnit
)
