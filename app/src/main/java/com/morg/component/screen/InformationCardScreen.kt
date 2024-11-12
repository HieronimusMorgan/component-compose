package com.morg.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.informationcard.InformationCardComponent
import co.id.nexsoft.component.informationcard.InformationCardType
import co.id.nexsoft.component.util.theme.CaptionLarge
import co.id.nexsoft.component.util.theme.CaptionMedium
import co.id.nexsoft.component.util.theme.ComponentType

@Preview(showBackground = true)
@Composable
fun InformationCardScreenPreview() {
    InformationCardScreen(navController = NavController(LocalContext.current))
}

@Composable
fun InformationCardScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val titlesAndDescriptions = listOf(
            "Exploring the Cosmos" to "Dive into the mysteries of space and uncover the secrets of distant galaxies.",
            "Mastering Kotlin Programming" to "Learn the ins and outs of Kotlin, from basics to advanced concepts, with practical examples.",
            "A Journey through Ancient Civilizations" to "Discover the cultures, achievements, and histories of ancient civilizations across the world.",
            "The Art of Mindfulness" to "Explore techniques to cultivate mindfulness and improve mental well-being in daily life."
        )
        Column {
            InformationCardType.entries.zip(titlesAndDescriptions).forEach { (type, value) ->
                InformationCardComponent(
                    modifier = Modifier.fillMaxWidth(),
                    title = value.first,
                    titleStyle = CaptionLarge,
                    titleFontWeight = FontWeight.Bold,
                    description = value.second,
                    descriptionStyle = CaptionMedium,
                    descriptionFontWeight = FontWeight.Normal,
                    closeImage = Icons.Filled.Close,
                    backgroundColor = Color.Transparent,
                    borderColor = Color.Transparent,
                    buttonType = ComponentType.TERTIARY,
                    buttonLabel = "Action",
                    buttonColor = Color.Black,
                    onClose = { /* Handle close */ },
                    onSubmit = { /* Handle submit */ },
                    type = type,
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}