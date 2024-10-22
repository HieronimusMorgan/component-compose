package com.morg.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
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
import com.morg.component.ui.theme.ComponentSize
import com.morg.component.ui.theme.ComponentType

@Preview(showBackground = true)
@Composable
fun ButtonComponentPreview() {
    ButtonComponent()
}

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
    val borderStroke = if (componentType == ComponentType.SECONDARY) BorderStroke(
        1.dp,
        componentColor
    ) else BorderStroke(0.dp, Color.Transparent)

    val buttonColors = when (componentType) {
        ComponentType.TERTIARY -> ButtonDefaults.outlinedButtonColors(contentColor = Color.Transparent)
        ComponentType.SECONDARY -> ButtonDefaults.outlinedButtonColors(contentColor = componentColor)
        else -> ButtonDefaults.buttonColors(contentColor = componentColor)
    }

    val button: @Composable RowScope.() -> Unit = {
        IconCustom(icon)
        TextCustom(
            label,
            if (componentType == ComponentType.PRIMARY) Color.White else componentColor,
            componentSize,
            textDecoration
        )
    }

    when (componentType) {
        ComponentType.TERTIARY, ComponentType.SECONDARY -> {
            OutlinedButton(
                onClick = onClick,
                border = borderStroke,
                shape = RoundedCornerShape(8.dp),
                enabled = enabled,
                modifier = modifier.height(height),
                colors = buttonColors,
                content = button
            )
        }

        else -> {
            Button(
                onClick = onClick,
                shape = RoundedCornerShape(8.dp),
                enabled = enabled,
                modifier = modifier.height(height),
                colors = buttonColors,
                content = button
            )
        }
    }
}

@Composable
fun TextCustom(
    label: String,
    componentColor: Color,
    componentSize: ComponentSize,
    textDecoration: TextDecoration
) {
    Text(
        text = label,
        color = componentColor,
        style = setComponentSize(componentSize).copy(textDecoration = textDecoration)
    )
}

@Composable
fun IconCustom(icon: ImageVector?) {
    icon?.let {
        Icon(
            imageVector = it,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
fun setComponentSize(size: ComponentSize): TextStyle {
    return when (size) {
        ComponentSize.SMALL -> TextStyle(fontSize = 12.sp)
        ComponentSize.MEDIUM -> TextStyle(fontSize = 14.sp)
        ComponentSize.LARGE -> TextStyle(fontSize = 16.sp)
    }
}
