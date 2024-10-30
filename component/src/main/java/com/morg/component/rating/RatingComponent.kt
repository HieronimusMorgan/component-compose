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

/**
 * The RatingComponent function takes several parameters: modifier, rating, maxRating, and onRatingChanged. The modifier parameter allows for custom modifications to the component, while rating specifies the initial rating value. The maxRating parameter defines the maximum rating value, and onRatingChanged is a callback function that is invoked when the rating is changed.
 * ``` kotlin
 * fun RatingComponent(
 *     modifier: Modifier = Modifier,
 *     rating: Float = 0f,
 *     maxRating: Int = 5,
 *     onRatingChanged: (Float) -> Unit = {}
 * )
 * ```
 *
 * Inside the function, a mutable state variable selectedRating is initialized using the remember function to store the current rating value. The initial value is set by rounding the rating parameter to the nearest integer.
 * ``` kotlin
 * var selectedRating by remember { mutableIntStateOf(rating.roundToInt()) }
 * ```
 *
 * The component uses a Row composable to arrange the star icons horizontally. A loop iterates from 1 to maxRating, creating an Icon composable for each star. The imageVector of the Icon is set to a filled star if the current index is less than or equal to selectedRating, otherwise, it is set to an outlined star.
 * ``` kotlin
 * for (i in 1..maxRating) {
 *     Icon(
 *         imageVector = if (i <= selectedRating) Icons.Filled.Star else Icons.Outlined.Star,
 *         contentDescription = null,
 *         tint = if (i <= selectedRating) MaterialTheme.colorScheme.primary else Color.Gray,
 *         modifier = Modifier
 *             .size(32.dp)
 *             .clickable {
 *                 selectedRating = i
 *                 onRatingChanged(i.toFloat())
 *             }
 *     )
 * }
 * ```
 *
 * The tint color of the Icon is set to the primary color of the theme if the star is filled, otherwise, it is set to gray. The clickable modifier is used to make each star icon interactive. When a star is clicked, the selectedRating is updated to the corresponding index, and the onRatingChanged callback is invoked with the new rating value.
 *
 * Additionally, a RatingComponentPreview function is provided to preview the RatingComponent in the Android Studio design editor. This function calls RatingComponent with default parameters.
 * ```kotlin
 * @Preview(showBackground = true)
 * @Composable
 * fun RatingComponentPreview() {
 *     RatingComponent()
 * }
 * ```
 * @param modifier Modifier to be applied to the rating component.
 * @param rating Initial rating value.
 * @param maxRating Maximum rating value.
 * @param onRatingChanged Callback function to be invoked when the rating is changed.
 */
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
