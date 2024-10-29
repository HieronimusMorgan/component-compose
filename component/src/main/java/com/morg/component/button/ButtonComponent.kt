package com.morg.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.morg.component.util.theme.ComponentSize
import com.morg.component.util.theme.ComponentType

@Preview(showBackground = true)
@Composable
fun ButtonComponentPreview() {
    ButtonComponent()
}

/**
 * A composable function that creates a customizable button component.
 *
 * @param modifier The modifier to be applied to the button.
 * @param label The text label to be displayed on the button.
 * @param componentType The type of the button, which determines its style (PRIMARY, SECONDARY, TERTIARY).
 * @param componentSize The size of the button (SMALL, MEDIUM, LARGE).
 * @param componentColor The color of the button's content.
 * @param icon An optional icon to be displayed on the button.
 * @param underline Whether the text label should be underlined.
 * @param enabled Whether the button is enabled or disabled.
 * @param onClick The callback to be invoked when the button is clicked.
 */
@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    label: String = "",
    componentType: ComponentType = ComponentType.PRIMARY,
    componentSize: ComponentSize = ComponentSize.MEDIUM,
    componentColor: Color = MaterialTheme.colorScheme.primary,
    icon: ImageVector? = null,
    underline: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    val height = when (componentSize) {
        ComponentSize.SMALL -> 32.dp
        ComponentSize.MEDIUM -> 40.dp
        ComponentSize.LARGE -> 48.dp
    }

    val textDecoration = if (underline) TextDecoration.Underline else TextDecoration.None
    val buttonColor = if (componentType == ComponentType.PRIMARY) Color.White else componentColor

    val buttonContent: @Composable RowScope.() -> Unit = {
        icon?.let {
            Icon(
                imageVector = it,
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = label,
            color = buttonColor,
            style = setTextComponentSize(componentSize).copy(textDecoration = textDecoration)
        )
    }

    val borderStroke = if (componentType == ComponentType.SECONDARY) BorderStroke(
        1.dp,
        componentColor
    ) else BorderStroke(0.dp, Color.Transparent)
    val buttonColors = if (componentType == ComponentType.TERTIARY) {
        ButtonDefaults.outlinedButtonColors(contentColor = Color.Transparent)
    } else {
        ButtonDefaults.outlinedButtonColors(contentColor = componentColor)
    }

    if (componentType == ComponentType.TERTIARY || componentType == ComponentType.SECONDARY) {
        OutlinedButton(
            onClick = onClick,
            border = borderStroke,
            shape = RoundedCornerShape(8.dp),
            enabled = enabled,
            modifier = modifier.height(height),
            colors = buttonColors,
            content = buttonContent
        )
    } else {
        Button(
            onClick = onClick,
            shape = RoundedCornerShape(8.dp),
            enabled = enabled,
            modifier = modifier.height(height),
            colors = ButtonDefaults.buttonColors(),
            content = buttonContent
        )
    }
}

@Composable
internal fun setTextComponentSize(size: ComponentSize): TextStyle {
    return when (size) {
        ComponentSize.SMALL -> TextStyle(fontSize = 12.sp)
        ComponentSize.MEDIUM -> TextStyle(fontSize = 14.sp)
        ComponentSize.LARGE -> TextStyle(fontSize = 16.sp)
    }
}
