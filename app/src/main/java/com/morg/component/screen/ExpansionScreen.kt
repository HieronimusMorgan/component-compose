package com.morg.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.expansion.ExpandableCard

@Preview(showBackground = true)
@Composable
fun ExpansionScreenPreview() {
    ExpansionScreen(navController = NavController(LocalContext.current))
}

@Composable
fun ExpansionScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            ExpandableCard(
                title = "Expandable Card Title",
                backgroundColor = Color(0xFFECECEC)
            ) {
                Text(
                    text = "This is the content that will be shown when the card is expanded.",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "You can add more components here, such as buttons, images, or any other UI elements.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}