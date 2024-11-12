package com.morg.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.rating.RatingComponent


@Composable
fun RatingScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {

            RatingComponent()
            Spacer(modifier = Modifier.padding(16.dp))
            RatingComponent()
            Spacer(modifier = Modifier.padding(16.dp))
            RatingComponent()
            Spacer(modifier = Modifier.padding(16.dp))
            RatingComponent()
            Spacer(modifier = Modifier.padding(16.dp))
        }
    }
}