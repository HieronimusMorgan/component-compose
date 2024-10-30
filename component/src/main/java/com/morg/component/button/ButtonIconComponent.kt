package com.morg.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.morg.component.util.theme.ComponentSize
import com.morg.component.util.theme.ComponentType

@Preview(showBackground = true)
@Composable
fun ButtonIconComponentPreview() {
    Column {
        Row {
            ButtonIconComponent(
                componentSize = ComponentSize.SMALL,
                componentType = ComponentType.PRIMARY,
                icon = Icons.Default.Add
            )
            Spacer(modifier = Modifier.size(16.dp))
            ButtonIconComponent(
                componentSize = ComponentSize.MEDIUM,
                componentType = ComponentType.PRIMARY,
                icon = Icons.Default.Add
            )
            Spacer(modifier = Modifier.size(16.dp))
            ButtonIconComponent(
                componentSize = ComponentSize.LARGE,
                componentType = ComponentType.PRIMARY,
                icon = Icons.Default.Add
            )

        }
        Spacer(modifier = Modifier.size(16.dp))
        Row {
            ButtonIconComponent(
                componentSize = ComponentSize.SMALL,
                componentType = ComponentType.SECONDARY,
                icon = Icons.Default.Add
            )
            Spacer(modifier = Modifier.size(16.dp))
            ButtonIconComponent(
                componentSize = ComponentSize.MEDIUM,
                componentType = ComponentType.SECONDARY,
                icon = Icons.Default.Add
            )
            Spacer(modifier = Modifier.size(16.dp))
            ButtonIconComponent(
                componentSize = ComponentSize.LARGE,
                componentType = ComponentType.SECONDARY,
                icon = Icons.Default.Add
            )

        }

        Spacer(modifier = Modifier.size(16.dp))
        Row {
            ButtonIconComponent(
                componentSize = ComponentSize.SMALL,
                componentType = ComponentType.TERTIARY,
                icon = Icons.Default.Add
            )
            Spacer(modifier = Modifier.size(16.dp))
            ButtonIconComponent(
                componentSize = ComponentSize.MEDIUM,
                componentType = ComponentType.TERTIARY,
                icon = Icons.Default.Add
            )
            Spacer(modifier = Modifier.size(16.dp))
            ButtonIconComponent(
                componentSize = ComponentSize.LARGE,
                componentType = ComponentType.TERTIARY,
                icon = Icons.Default.Add
            )
        }
    }
}

@Composable
fun ButtonIconComponent(
    modifier: Modifier = Modifier,
    componentType: ComponentType = ComponentType.PRIMARY,
    componentSize: ComponentSize = ComponentSize.MEDIUM,
    componentColor: Color = MaterialTheme.colorScheme.primary,
    icon: ImageVector = Icons.Filled.Add,
    iconColor: Color = Color.Black,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {

    val size = when (componentSize) {
        ComponentSize.SMALL -> 32.dp
        ComponentSize.MEDIUM -> 40.dp
        ComponentSize.LARGE -> 48.dp
    }
    val color = when (componentType) {
        ComponentType.PRIMARY -> componentColor
        ComponentType.SECONDARY, ComponentType.TERTIARY -> Color.White
    }
    val borderTertiary: BorderStroke = when (componentType) {
        ComponentType.TERTIARY -> BorderStroke(0.dp, color)
        ComponentType.PRIMARY, ComponentType.SECONDARY -> BorderStroke(1.dp, componentColor)
    }
    Box(
        modifier = modifier// Size of the Box
            .clip(RoundedCornerShape(4.dp))
            .background(color)
            .border(
                borderTertiary, // Outline with negative color
                RoundedCornerShape(4.dp) // Match the corner shape of the box
            )
    ) {
        IconButton(
            onClick = onClick,
            enabled = enabled,
            modifier = modifier.size(size),
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = modifier.size(size) // Icon size
            )
        }
    }
}