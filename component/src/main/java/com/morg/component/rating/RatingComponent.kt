package com.morg.component.rating

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Preview(showBackground = true)
@Composable
fun RatingComponentPreview() {
    RatingComponent()
}

@Composable
fun RatingComponent(
    modifier: Modifier = Modifier,
    rating: Float = 0f,
    maxRating: Int = 5,
    onRatingChanged: (Float) -> Unit = {}
) {
    var selectedRating by remember { mutableIntStateOf(rating.roundToInt()) }

    Row(modifier = modifier) {
        for (i in 1..maxRating) {
            Icon(
                imageVector = if (i <= selectedRating) Icons.Filled.Star else Icons.Outlined.Star,
                contentDescription = null,
                tint = if (i <= selectedRating) MaterialTheme.colorScheme.primary else Color.Gray,
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        selectedRating = i
                        onRatingChanged(i.toFloat())
                    }
            )
        }
    }
}
