package co.id.nexsoft.component.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import co.id.nexsoft.component.R
import co.id.nexsoft.component.util.theme.BodyLarge
import co.id.nexsoft.component.util.theme.BodyMedium
import co.id.nexsoft.component.util.theme.BodySmall
import co.id.nexsoft.component.util.theme.ComponentSize

@Preview(showBackground = true)
@Composable
fun RoundedInputStepperPreview() {
    StepperComponent(
        initialValue = 0,
        minValue = 0,
        maxValue = 10000,
        componentSize = ComponentSize.SMALL,
        iconColor = Color.Black,
        borderColor = Color.Gray,
        onValueChange = { /* Add your logic here */ }
    )
}

@Composable
fun StepperComponent(
    initialValue: Int = 0,
    minValue: Int = 0,
    maxValue: Int = 10000,
    isBorderless: Boolean = false,
    componentSize: ComponentSize = ComponentSize.SMALL,
    iconColor: Color = Color.Black,
    borderColor: Color = Color.Gray,
    onValueChange: (Int) -> Unit = {}
) {
    var value by remember { mutableIntStateOf(initialValue) }
    var textValue by remember { mutableStateOf(TextFieldValue(value.toString())) }

    onValueChange(value)

    val iconSizeModifier = when (componentSize) {
        ComponentSize.SMALL -> Modifier.size(20.dp)
        ComponentSize.MEDIUM -> Modifier.size(24.dp)
        ComponentSize.LARGE -> Modifier.size(28.dp)
    }

    val textStyle = when (componentSize) {
        ComponentSize.SMALL -> BodySmall
        ComponentSize.MEDIUM -> BodyMedium
        ComponentSize.LARGE -> BodyLarge
    }

    val backgroundModifier = if (isBorderless) {
        Modifier
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    } else {
        Modifier
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .border(1.dp, borderColor, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    }

    ConstraintLayout(
        modifier = backgroundModifier.wrapContentWidth()
    ) {
        val (minusButton, textField, plusButton) = createRefs()

        StepperButton(modifier = Modifier
            .then(iconSizeModifier)
            .constrainAs(minusButton) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }, iconResId = R.drawable.ic_stepper_minus_component, onClick = {
            if (value > minValue) {
                value -= 1
                textValue = TextFieldValue(value.toString())
            }
        }, enabled = value > minValue, iconColor = iconColor
        )

        TextField(value = textValue, onValueChange = {
            val newValue = it.text.toIntOrNull()
            if (newValue != null && newValue in minValue..maxValue) {
                value = newValue
                textValue = it
            } else if (it.text.isEmpty()) {
                textValue = it
            }
        }, textStyle = textStyle.copy(
            textAlign = TextAlign.Center
        ), colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Color.Transparent
        ), modifier = Modifier
            .padding(top = 4.dp)
            .constrainAs(textField) {
                start.linkTo(minusButton.end, margin = 8.dp)
                end.linkTo(plusButton.start, margin = 8.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                width = when (componentSize) {
                    ComponentSize.SMALL -> Dimension.value(58.dp)
                    ComponentSize.MEDIUM -> Dimension.value(66.dp)
                    else -> Dimension.value(76.dp)
                }
                height = when (componentSize) {
                    ComponentSize.SMALL -> Dimension.value(48.dp)
                    ComponentSize.MEDIUM -> Dimension.value(56.dp)
                    else -> Dimension.value(66.dp)
                }
            }

        )
        StepperButton(modifier = Modifier
            .then(iconSizeModifier)
            .constrainAs(plusButton) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }, iconResId = R.drawable.ic_stepper_plus_component, onClick = {
            if (value < maxValue) {
                value += 1
                textValue = TextFieldValue(value.toString())
            }
        }, enabled = value < maxValue, iconColor = iconColor
        )
    }
}

@Composable
fun StepperButton(
    modifier: Modifier = Modifier,
    iconResId: Int,
    onClick: () -> Unit,
    enabled: Boolean,
    iconColor: Color
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
    ) {
        Icon(
            painter = painterResource(id = iconResId), contentDescription = null, tint = iconColor
        )
    }
}
