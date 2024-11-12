package com.morg.component.screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.button.ButtonComponent
import co.id.nexsoft.component.util.theme.ComponentSize
import co.id.nexsoft.component.util.theme.ComponentType
import co.id.nexsoft.component.util.theme.ImageSource
import com.morg.component.R

@Preview(showBackground = true)
@Composable
fun ButtonScreenPreview() {
    ButtonScreen(navController = NavController(LocalContext.current))
}

@Composable
fun ButtonScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Column {
            ButtonPrimary()

            ButtonSecondary()

            ButtonTertiary()

            ButtonUnderline()

            ButtonIconLeft()

            ButtonIconRight()

            ButtonIconRightAndLeft()
        }
    }
}

@Composable
private fun ButtonPrimary() {
    Text(text = "Button Primary")
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ComponentSize.entries.forEach {
            ButtonComponent(
                componentSize = it,
                componentType = ComponentType.PRIMARY,
                label = "Button"
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun ButtonSecondary() {
    Text(text = "Button Secondary")
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ComponentSize.entries.forEach {
            ButtonComponent(
                componentSize = it,
                componentType = ComponentType.SECONDARY,
                label = "Button"
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun ButtonTertiary() {
    Text(text = "Button Tertiary")
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ComponentSize.entries.forEach {
            ButtonComponent(
                componentSize = it,
                componentType = ComponentType.TERTIARY,
                label = "Button"
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun ButtonUnderline() {
    Text(text = "Button Underline")
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ComponentSize.entries.forEach {
            ButtonComponent(
                componentSize = it,
                componentType = ComponentType.PRIMARY,
                underline = true,
                label = "Button"
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun ButtonIconLeft() {
    Text(text = "Button Underline")
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ComponentSize.entries.forEach {
            ButtonComponent(
                componentSize = it,
                componentType = ComponentType.PRIMARY,
                drawableStart = ImageSource.VectorImage(Icons.Default.Lock),
                label = "Button"
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun ButtonIconRight() {
    Text(text = "Button Underline")
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ComponentSize.entries.forEach {
            ButtonComponent(
                componentSize = it,
                componentType = ComponentType.PRIMARY,
                drawableEnd = ImageSource.VectorImage(Icons.Default.Lock),
                label = "Button"
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun ButtonIconRightAndLeft() {
    Text(text = "Button Underline")
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        ComponentSize.entries.forEach {
            ButtonComponent(
                componentSize = it,
                componentType = ComponentType.PRIMARY,
                drawableStart = ImageSource.DrawableResource(R.drawable.ic_group_logo), // Add the icon here
                drawableEnd = ImageSource.VectorImage(Icons.Default.Lock), // Add the icon here
                label = "Button"
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}
