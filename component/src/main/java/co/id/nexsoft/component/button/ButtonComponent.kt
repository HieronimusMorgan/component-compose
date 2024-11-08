package co.id.nexsoft.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.id.nexsoft.component.util.theme.ComponentSize
import co.id.nexsoft.component.util.theme.ComponentType
import co.id.nexsoft.component.util.theme.setId

@Preview(showBackground = true)
@Composable
fun ButtonComponentPreview() {
    Column {
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            drawableStart = Icons.Filled.Lock,
            drawableEnd = Icons.Filled.Lock,
            label = "Button"
        )
        ButtonComponent(
            modifier = Modifier,
            id = "btn_1",
            label = "Button",
            componentType = ComponentType.PRIMARY,
            componentSize = ComponentSize.MEDIUM,
            componentColor = MaterialTheme.colorScheme.primary,
            drawableStart = null,
            drawableEnd = null,
            underline = false,
            enabled = true,
            onClick = {},
        )
    }
}

/**
 * The ButtonComponent function is a composable function in Kotlin that creates a customizable button using Jetpack Compose. This function allows developers to define various aspects of the button's appearance and behavior through its parameters.
 *
 * The modifier parameter allows you to apply custom modifications to the button, such as setting its layout properties. The id parameter is an optional identifier for the button, which is used to set a unique layout ID:
 * ```
 * modifier.layoutId("btn_\${setId(id, label)}")
 * ```
 *The label parameter specifies the text to be displayed on the button. The componentType parameter determines the style of the button, which can be PRIMARY, SECONDARY, or TERTIARY. The componentSize parameter defines the size of the button, which can be SMALL, MEDIUM, or LARGE. The componentColor parameter sets the color of the button's content.
 *
 * The drawableStart and drawableEnd parameters are optional icons that can be displayed at the start and end of the button, respectively. The underline parameter specifies whether the text label should be underlined. The enabled parameter determines whether the button is enabled or disabled. The onClick parameter is a callback function that is invoked when the button is clicked.
 * The function calculates the height of the button based on the componentSize parameter
 * ``` kotlin
 * val height = when (componentSize) {
 *     ComponentSize.SMALL -> 32.dp
 *     ComponentSize.MEDIUM -> 40.dp
 *     ComponentSize.LARGE -> 48.dp
 * }
 * ```
 *
 * It also sets the text decoration based on the underline parameter and determines the button color based on the componentType:
 * ```
 * val textDecoration = if (underline) TextDecoration.Underline else TextDecoration.None
 * val buttonColor = if (componentType == ComponentType.PRIMARY) Color.White else componentColor
 * ```
 *
 * The buttonContent variable is a composable lambda that defines the content of the button, including the optional icon and the text label:
 * ```
 * val buttonContent: @Composable RowScope.() -> Unit = {
 *     drawableStart?.let {
 *         Icon(imageVector = it, contentDescription = null, tint = Color.White)
 *         Spacer(modifier = Modifier.weight(1f))
 *     }
 *     Text(text = label, color = buttonColor, style = setTextComponentSize(componentSize).copy(textDecoration = textDecoration))
 *     drawableEnd?.let {
 *         Spacer(modifier = Modifier.weight(1f))
 *         Icon(imageVector = it, contentDescription = null, tint = Color.White)
 *     }
 * }
 * ```
 * The function sets the border stroke and button colors based on the componentType:
 * ```
 * val borderStroke = if (componentType == ComponentType.SECONDARY) BorderStroke(
 *     1.dp,
 *     componentColor
 * ) else BorderStroke(0.dp, Color.Transparent)
 * val buttonColors = if (componentType == ComponentType.TERTIARY) {
 *     ButtonDefaults.outlinedButtonColors(contentColor = Color.Transparent)
 * } else {
 *     ButtonDefaults.outlinedButtonColors(contentColor = componentColor)
 * }
 * ```
 *
 * Finally, the function uses conditional logic to determine whether to create an OutlinedButton or a regular Button based on the componentType:
 * ```
 * if (componentType == ComponentType.TERTIARY || componentType == ComponentType.SECONDARY) {
 *     OutlinedButton(
 *         onClick = onClick,
 *         border = borderStroke,
 *         shape = RoundedCornerShape(8.dp),
 *         enabled = enabled,
 *         modifier = modifier.height(height),
 *         colors = buttonColors,
 *         content = buttonContent
 *     )
 * } else {
 *     Button(
 *         onClick = onClick,
 *         shape = RoundedCornerShape(8.dp),
 *         enabled = enabled,
 *         modifier = modifier.height(height),
 *         colors = ButtonDefaults.buttonColors(),
 *         content = buttonContent
 *     )
 * }
 * ```
 * The setTextComponentSize function is an internal helper function that returns a TextStyle based on the componentSize parameter:
 * ```
 * @Composable
 * internal fun setTextComponentSize(size: ComponentSize): TextStyle {
 *     return when (size) {
 *         ComponentSize.SMALL -> TextStyle(fontSize = 12.sp)
 *         ComponentSize.MEDIUM -> TextStyle(fontSize = 14.sp)
 *         ComponentSize.LARGE -> TextStyle(fontSize = 16.sp)
 *     }
 * }
 * ```
 * @param modifier The modifier to be applied to the button.
 * @param id The optional ID for the button.
 * @param label The text label to be displayed on the button.
 * @param componentType The type of the button, which determines its style (PRIMARY, SECONDARY, TERTIARY).
 * @param componentSize The size of the button (SMALL, MEDIUM, LARGE).
 * @param componentColor The color of the button's content.
 * @param drawableStart An optional icon to be displayed at the start of the button.
 * @param drawableEnd An optional icon to be displayed at the end of the button.
 * @param underline Whether the text label should be underlined.
 * @param enabled Whether the button is enabled or disabled.
 * @param onClick The callback to be invoked when the button is clicked.
 */
@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    id: String? = null,
    label: String = "",
    componentType: ComponentType = ComponentType.PRIMARY,
    componentSize: ComponentSize = ComponentSize.MEDIUM,
    componentColor: Color = MaterialTheme.colorScheme.primary,
    drawableStart: ImageVector? = null,
    drawableEnd: ImageVector? = null,
    underline: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    modifier.layoutId("btn_${setId(id, label)}")

    val height = when (componentSize) {
        ComponentSize.SMALL -> 32.dp
        ComponentSize.MEDIUM -> 40.dp
        ComponentSize.LARGE -> 48.dp
    }

    val textDecoration = if (underline) TextDecoration.Underline else TextDecoration.None
    val buttonColor = if (componentType == ComponentType.PRIMARY) Color.White else componentColor

    val buttonContent: @Composable RowScope.() -> Unit = {
        drawableStart?.let {
            Icon(
                imageVector = it, contentDescription = null, tint = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Text(
            text = label,
            color = buttonColor,
            style = setTextComponentSize(componentSize).copy(textDecoration = textDecoration)
        )
        drawableEnd?.let {
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = it, contentDescription = null, tint = Color.White
            )
        }
    }

    val borderStroke = if (componentType == ComponentType.SECONDARY) BorderStroke(
        1.dp, componentColor
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
            colors = ButtonDefaults.buttonColors(componentColor),
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
