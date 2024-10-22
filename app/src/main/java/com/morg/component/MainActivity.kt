package com.morg.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.morg.component.button.ButtonComponent
import com.morg.component.ui.theme.ComponentSize
import com.morg.component.ui.theme.ComponentTheme
import com.morg.component.ui.theme.ComponentType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentTheme(darkTheme = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Button Component Medium")
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentSize = ComponentSize.MEDIUM
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentType = ComponentType.SECONDARY,
            componentSize = ComponentSize.MEDIUM
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentType = ComponentType.TERTIARY,
            componentSize = ComponentSize.MEDIUM
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "Button Component Small")
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentSize = ComponentSize.SMALL
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentType = ComponentType.SECONDARY,
            componentSize = ComponentSize.SMALL
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentType = ComponentType.TERTIARY,
            componentSize = ComponentSize.SMALL
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "Button Component Large")
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            underline = true,
            componentSize = ComponentSize.LARGE
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentType = ComponentType.SECONDARY,
            componentSize = ComponentSize.LARGE
        )
        Spacer(modifier = Modifier.height(5.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            label = "Button",
            componentType = ComponentType.TERTIARY,
            componentSize = ComponentSize.LARGE
        )
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComponentTheme {
        Greeting()
    }
}