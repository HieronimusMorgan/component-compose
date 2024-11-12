package co.id.nexsoft.component.expansion

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ExpandableCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
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

@Composable
fun ExpandableCard(
    title: String,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    durationMillis: Int = 1000,
    divider: Boolean = true,
    dividerThickness: Dp = 1.dp,
    dividerColor: Color = DividerDefaults.color,
    content: @Composable () -> Unit // Content as a lambda
) {
    var expanded by remember { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(targetValue = if (expanded) 180f else 0f, label = "")

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = Icons.Default.ExpandMore,
                        contentDescription = if (expanded) "Collapse" else "Expand",
                        modifier = Modifier.rotate(rotationAngle)
                    )
                }
            }
            if (divider) {
                HorizontalDivider(
                    color = dividerColor,
                    thickness = dividerThickness,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn(animationSpec = tween(durationMillis = durationMillis)) +
                        slideInVertically(
                            initialOffsetY = { -40 },
                            animationSpec = tween(durationMillis = durationMillis)
                        ),
                exit = fadeOut(animationSpec = tween(durationMillis = durationMillis)) +
                        slideOutVertically(
                            targetOffsetY = { -40 },
                            animationSpec = tween(durationMillis = durationMillis)
                        )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(backgroundColor)
                        .padding(8.dp)
                ) {
                    content() // Invoke the content lambda
                }
            }
        }
    }
}