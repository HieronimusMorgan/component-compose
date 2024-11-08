package co.id.nexsoft.component.informationcard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import co.id.nexsoft.component.R
import co.id.nexsoft.component.button.ButtonComponent
import co.id.nexsoft.component.util.theme.CaptionLarge
import co.id.nexsoft.component.util.theme.CaptionMedium
import co.id.nexsoft.component.util.theme.ComponentType
import co.id.nexsoft.component.util.theme.colorBackgroundDanger
import co.id.nexsoft.component.util.theme.colorBackgroundInfo
import co.id.nexsoft.component.util.theme.colorBackgroundSuccess
import co.id.nexsoft.component.util.theme.colorBackgroundWarning
import co.id.nexsoft.component.util.theme.colorBorderDangerWeak
import co.id.nexsoft.component.util.theme.colorBorderInfoWeak
import co.id.nexsoft.component.util.theme.colorBorderSuccessWeak
import co.id.nexsoft.component.util.theme.colorBorderWarningWeak

@Preview(showBackground = true)
@Composable
fun InformationCardComponentPreview() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        InformationCardType.entries.forEach { type ->
            InformationCardComponent(
                modifier = Modifier.fillMaxWidth(),
                title = type.name,
                titleStyle = CaptionLarge,
                titleFontWeight = FontWeight.Bold,
                description = "This warning in Android Studio's Layout Editor is just a note indicating that the preview tool currently only supports rendering up to API level 34. If you're targeting a higher API, the preview might not accurately reflect how the layout would look or behave on devices with newer APIs, especially if you’re using features that were added after API 34.",
                descriptionStyle = CaptionMedium,
                descriptionFontWeight = FontWeight.Normal,
                iconImage = R.drawable.ic_warning_component,
                closeImage = Icons.Filled.Close,
                backgroundColor = Color.Transparent,
                borderColor = Color.Transparent,
                buttonType = ComponentType.TERTIARY,
                buttonLabel = "Action",
                buttonColor = Color.Black,
                onClose = { /* Handle close */ },
                onSubmit = { /* Handle submit */ },
                type = InformationCardType.SUCCESS,
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

/**
 * The InformationCardComponent is a composable function in Kotlin that displays an information card with a title, description, button, and close icon. It uses Jetpack Compose for UI rendering. The function accepts several parameters, including modifier, title, description, buttonLabel, buttonColor, onClose, onSubmit, and type. The type parameter determines the appearance of the card, such as its color and icon.
 * ``` kotlin
 * @Composable
 * fun InformationCardComponent(
 *     modifier: Modifier = Modifier,
 *     title: String,
 *     description: String,
 *     buttonLabel: String,
 *     buttonColor: Color = Color.Black,
 *     onClose: () -> Unit = {},
 *     onSubmit: () -> Unit = {},
 *     type: InformationCardType = InformationCardType.SUCCESS
 * )
 * ```
 *The card's visibility is controlled by a mutable state variable isVisible, which is initially set to true. The AnimatedVisibility composable is used to animate the card's appearance and disappearance with fade and slide effects.
 * ``` kotlin
 * var isVisible by remember { mutableStateOf(true) }
 *
 * AnimatedVisibility(
 *     visible = isVisible,
 *     enter = fadeIn() + slideInVertically(initialOffsetY = { -40 }),
 *     exit = fadeOut() + slideOutVertically(targetOffsetY = { -40 })
 * )
 * ```
 * The Card composable is used to create the card's container, which is styled with padding, border, and background color based on the type parameter. The ConstraintLayout composable is used to arrange the card's content, including the icon, close button, title, description, and action button.
 * ``` kotlin
 * Card(
 *     modifier = modifier
 *         .fillMaxWidth()
 *         .wrapContentHeight()
 *         .padding(8.dp)
 *         .border(1.dp, getColor(type), RoundedCornerShape(8.dp))
 *         .animateContentSize(),
 *     colors = CardDefaults.cardColors(getBackgroundColor(type))
 * )
 * ```
 *
 * The Image composable is used to display the icon and close button. The close button is clickable and sets isVisible to false when clicked, triggering the onClose callback.
 * ``` kotlin
 * Image(
 *     imageVector = Icons.Filled.Close,
 *     contentDescription = null,
 *     modifier = Modifier
 *         .constrainAs(close) {
 *             top.linkTo(parent.top, margin = 12.dp)
 *             end.linkTo(parent.end, margin = 12.dp)
 *         }
 *         .size(24.dp)
 *         .clickable {
 *             isVisible = false
 *             onClose()
 *         },
 *     contentScale = ContentScale.Fit
 * )
 * ```
 *
 * The Text composable is used to display the title and description text with specific styles. The ButtonComponent composable is used to create the action button with the specified label, color, and onClick callback.
 * ``` kotlin
 * ButtonComponent(
 *     modifier = Modifier.constrainAs(button) {
 *         top.linkTo(descriptionText.bottom, margin = 12.dp)
 *         end.linkTo(parent.end, margin = 12.dp)
 *         bottom.linkTo(parent.bottom, margin = 12.dp)
 *     },
 *     componentType = ComponentType.TERTIARY,
 *     componentColor = buttonColor,
 *     label = buttonLabel,
 *     onClick = {
 *         isVisible = false
 *         onSubmit()
 *     }
 * )
 * ```
 * @param modifier Modifier to be applied to the card.
 * @param title The title text to be displayed in the card.
 * @param description The description text to be displayed in the card.
 * @param buttonLabel The label text for the button in the card.
 * @param buttonColor The color of the button in the card. Default is Color.Black.
 * @param onClose Callback function to be invoked when the close button is clicked.
 * @param onSubmit Callback function to be invoked when the submit button is clicked.
 * @param type The type of the information card, which determines its appearance. Default is InformationCardType.SUCCESS.
 */
@Composable
fun InformationCardComponent(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = CaptionLarge,
    titleFontWeight: FontWeight = FontWeight.Bold,
    description: String,
    descriptionStyle: TextStyle = CaptionMedium,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    iconImage: Int = 0,
    closeImage: ImageVector = Icons.Filled.Close,
    backgroundColor: Color = Color.Transparent,
    borderColor: Color = Color.Transparent,
    buttonType: ComponentType = ComponentType.TERTIARY,
    buttonLabel: String,
    buttonColor: Color = Color.Black,
    onClose: () -> Unit = {},
    onSubmit: () -> Unit = {},
    type: InformationCardType = InformationCardType.SUCCESS
) {
    var isVisible by remember { mutableStateOf(true) }

    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn() + slideInVertically(initialOffsetY = { -40 }),
        exit = fadeOut() + slideOutVertically(targetOffsetY = { -40 })
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp)
                .border(1.dp, getColor(type, borderColor), RoundedCornerShape(8.dp))
                .animateContentSize(),
            colors = CardDefaults.cardColors(getBackgroundColor(type, backgroundColor))
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                val (icon, close, button, titleText, descriptionText) = createRefs()

                Image(painter = painterResource(id = getIcon(type, iconImage)),
                    contentDescription = null,
                    modifier = Modifier
                        .constrainAs(icon) {
                            top.linkTo(parent.top, margin = 12.dp)
                            start.linkTo(parent.start, margin = 12.dp)
                        }
                        .size(16.dp),
                    contentScale = ContentScale.Fit)

                Image(imageVector = closeImage,
                    contentDescription = null,
                    modifier = Modifier
                        .constrainAs(close) {
                            top.linkTo(icon.top)
                            end.linkTo(parent.end, margin = 12.dp)
                            bottom.linkTo(icon.bottom)
                        }
                        .size(24.dp)
                        .clickable {
                            isVisible = false
                            onClose()
                        },
                    contentScale = ContentScale.Fit
                )

                Text(text = title,
                    style = titleStyle,
                    fontWeight = titleFontWeight,
                    modifier = Modifier.constrainAs(titleText) {
                        top.linkTo(parent.top, margin = 12.dp)
                        start.linkTo(icon.end, margin = 12.dp)
                        end.linkTo(close.start, margin = 12.dp)
                        bottom.linkTo(icon.bottom)
                        width = Dimension.fillToConstraints
                    })

                Text(text = description,
                    style = descriptionStyle,
                    fontWeight = descriptionFontWeight,
                    modifier = Modifier.constrainAs(descriptionText) {
                        top.linkTo(titleText.bottom, margin = 12.dp)
                        start.linkTo(icon.end, margin = 12.dp)
                        end.linkTo(parent.end, margin = 12.dp)
                        width = Dimension.fillToConstraints
                    })

                ButtonComponent(modifier = Modifier.constrainAs(button) {
                    top.linkTo(descriptionText.bottom, margin = 12.dp)
                    end.linkTo(parent.end, margin = 12.dp)
                    bottom.linkTo(parent.bottom, margin = 12.dp)
                },
                    componentType = buttonType,
                    componentColor = buttonColor,
                    label = buttonLabel,
                    onClick = {
                        isVisible = false
                        onSubmit()
                    })
            }
        }
    }
}

@Composable
fun getColor(type: InformationCardType, borderColor: Color): Color {
    return if (borderColor != Color.Transparent) borderColor
    else when (type) {
        InformationCardType.SUCCESS -> colorBorderSuccessWeak
        InformationCardType.WARNING -> colorBorderWarningWeak
        InformationCardType.ERROR -> colorBorderDangerWeak
        InformationCardType.INFO -> colorBorderInfoWeak
    }
}

@Composable
fun getBackgroundColor(type: InformationCardType, backgroundColor: Color): Color {
    return if (backgroundColor != Color.Transparent) backgroundColor
    else when (type) {
        InformationCardType.SUCCESS -> colorBackgroundSuccess
        InformationCardType.WARNING -> colorBackgroundWarning
        InformationCardType.ERROR -> colorBackgroundDanger
        InformationCardType.INFO -> colorBackgroundInfo
    }
}

@Composable
fun getIcon(type: InformationCardType, iconImage: Int): Int {
    return if (iconImage != 0) iconImage
    else when (type) {
        InformationCardType.SUCCESS -> R.drawable.ic_check_circle_component
        InformationCardType.WARNING -> R.drawable.ic_warning_component
        InformationCardType.ERROR -> R.drawable.ic_error_component
        InformationCardType.INFO -> R.drawable.ic_information_component
    }
}

enum class InformationCardType {
    SUCCESS, WARNING, ERROR, INFO
}
