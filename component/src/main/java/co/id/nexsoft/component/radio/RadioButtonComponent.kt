package co.id.nexsoft.component.radio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import co.id.nexsoft.component.textfield.iconSizeForComponentSize
import co.id.nexsoft.component.util.theme.BodyLarge
import co.id.nexsoft.component.util.theme.CaptionLarge
import co.id.nexsoft.component.util.theme.CaptionMedium
import co.id.nexsoft.component.util.theme.ComponentSize
import co.id.nexsoft.component.util.theme.ImageSource
import co.id.nexsoft.component.util.theme.SpacingComponent
import co.id.nexsoft.component.util.theme.colorText
import co.id.nexsoft.component.util.theme.setId

@Preview(showBackground = true)
@Composable
fun RadioComponentPreview() {
    val options = mapOf("option1" to "Option 1", "option2" to "Option 2", "option3" to "Option 3")
    RadioButtonComponent(title = "Radio Component", options = options, onOptionSelected = {})
}

@Composable
fun RadioButtonComponent(
    modifier: Modifier = Modifier,
    id: String? = null,
    title: String = "",
    titleStyle: TextStyle = BodyLarge.merge(fontWeight = FontWeight.Bold),
    titleColor: Color = colorText,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unSelectedColor: Color = Color.Gray,
    verticalAlignment: Boolean = false,
    componentSize: ComponentSize = ComponentSize.MEDIUM,
    options: Map<String, String>,
    onOptionSelected: (String) -> Unit,
    informationText: String = "",
    informationTextStyle: TextStyle = CaptionMedium,
    informationTextColor: Color = colorText,
    informationIcon: ImageSource = ImageSource.VectorImage(Icons.Outlined.Info),
    informationIconColor: Color = colorText,
    errorText: String = "",
    errorTextStyle: TextStyle = CaptionMedium,
    errorTextColor: Color = MaterialTheme.colorScheme.error,
    errorIcon: ImageSource = ImageSource.VectorImage(Icons.Outlined.Info),
    errorIconColor: Color = MaterialTheme.colorScheme.error,
) {
    var selectedKey by remember { mutableStateOf<String?>(null) }
    modifier.layoutId("radio_${setId(id, "")}")

    Column(modifier = modifier.fillMaxWidth()) {

        val (radioSize, textFontSize, textStyle, spacing) = when (componentSize) {
            ComponentSize.SMALL -> Quad(
                SpacingComponent.Md16,
                SpacingComponent.Sm12.value.sp,
                CaptionMedium,
                SpacingComponent.Sm12
            )

            ComponentSize.MEDIUM -> Quad(
                SpacingComponent.Md20,
                SpacingComponent.Sm14.value.sp,
                CaptionLarge,
                SpacingComponent.Md16
            )

            ComponentSize.LARGE -> Quad(
                SpacingComponent.Md24,
                SpacingComponent.Md16.value.sp,
                BodyLarge,
                SpacingComponent.Md20
            )
        }
        if (title.isNotEmpty()) {
            Text(text = title, style = titleStyle, color = titleColor, fontSize = textFontSize)
            Spacer(modifier = Modifier.height(SpacingComponent.Sm8))
        }

        if (verticalAlignment) {
            options.forEach { (key, label) ->
                RadioOption(
                    key,
                    label,
                    selectedKey,
                    radioSize,
                    textFontSize,
                    textStyle,
                    selectedColor,
                    unSelectedColor
                ) {
                    selectedKey = it
                    onOptionSelected(it)
                }
                Spacer(modifier = Modifier.height(spacing))
            }
        } else {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                options.forEach { (key, label) ->
                    RadioOption(
                        key,
                        label,
                        selectedKey,
                        radioSize,
                        textFontSize,
                        textStyle,
                        selectedColor,
                        unSelectedColor
                    ) {
                        selectedKey = it
                        onOptionSelected(it)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(SpacingComponent.Sm8))
        if (informationText.isNotEmpty()) {
            InformationText(
                componentSize,
                textFontSize,
                informationText,
                informationTextStyle,
                informationTextColor,
                informationIcon,
                informationIconColor
            )
            Spacer(modifier = Modifier.height(SpacingComponent.Sm8))
        }
        if (errorText.isNotEmpty()) {
            ErrorText(
                componentSize,
                textFontSize,
                errorText,
                errorTextStyle,
                errorTextColor,
                errorIcon,
                errorIconColor
            )
            Spacer(modifier = Modifier.height(SpacingComponent.Sm8))
        }
    }
}

@Composable
private fun RadioOption(
    key: String,
    label: String,
    selectedKey: String?,
    radioSize: Dp,
    textFontSize: TextUnit,
    textStyle: TextStyle,
    selectedColor: Color,
    unSelectedColor: Color,
    onOptionSelected: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(SpacingComponent.Sm8)
            .wrapContentWidth()
            .clickable(onClick = { onOptionSelected(key) },
                indication = null,
                interactionSource = remember { MutableInteractionSource() })
    ) {
        Box(
            modifier = Modifier
                .size(radioSize)

        ) {
            RadioButton(
                selected = selectedKey == key,
                onClick = null,
                colors = RadioButtonDefaults.colors(
                    selectedColor = selectedColor,
                    unselectedColor = unSelectedColor
                )
            )
        }
        Spacer(modifier = Modifier.width(SpacingComponent.Sm4))
        Text(text = label, fontSize = textFontSize, style = textStyle, color = colorText)
    }
}

@Composable
fun InformationText(
    componentSize: ComponentSize,
    textFontSize: TextUnit,
    informationText: String,
    informationTextStyle: TextStyle,
    informationTextColor: Color,
    informationIcon: ImageSource,
    informationIconColor: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        when (informationIcon) {
            is ImageSource.VectorImage -> Icon(
                modifier = Modifier.size(
                    iconSizeForComponentSize(
                        componentSize
                    )
                ),
                imageVector = informationIcon.imageVector,
                contentDescription = null,
                tint = informationIconColor
            )

            is ImageSource.UrlImage -> Icon(
                modifier = Modifier.size(
                    iconSizeForComponentSize(
                        componentSize
                    )
                ),
                imageVector = Icons.Outlined.Info,
                contentDescription = null,
                tint = informationIconColor
            )

            is ImageSource.DrawableResource -> Icon(
                modifier = Modifier.size(
                    iconSizeForComponentSize(componentSize)
                ),
                painter = painterResource(id = informationIcon.resId),
                contentDescription = null,
                tint = informationIconColor
            )
        }
        Spacer(modifier = Modifier.width(SpacingComponent.Sm4))
        Text(
            text = informationText,
            style = informationTextStyle,
            color = informationTextColor,
            fontSize = textFontSize
        )
    }
}

@Composable
fun ErrorText(
    componentSize: ComponentSize,
    textFontSize: TextUnit,
    errorText: String,
    errorTextStyle: TextStyle,
    errorTextColor: Color,
    errorIcon: ImageSource,
    errorIconColor: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        when (errorIcon) {
            is ImageSource.VectorImage -> Icon(
                modifier = Modifier.size(
                    iconSizeForComponentSize(
                        componentSize
                    )
                ),
                imageVector = errorIcon.imageVector,
                contentDescription = null,
                tint = errorIconColor
            )

            is ImageSource.UrlImage -> Icon(
                modifier = Modifier.size(
                    iconSizeForComponentSize(
                        componentSize
                    )
                ),
                imageVector = Icons.Outlined.Info,
                contentDescription = null,
                tint = errorIconColor
            )

            is ImageSource.DrawableResource -> Icon(
                modifier = Modifier.size(
                    iconSizeForComponentSize(componentSize)
                ),
                painter = painterResource(id = errorIcon.resId),
                contentDescription = null,
                tint = errorIconColor
            )
        }
        Spacer(modifier = Modifier.width(SpacingComponent.Sm4))
        Text(
            text = errorText,
            style = errorTextStyle,
            color = errorTextColor,
            fontSize = textFontSize
        )
    }
}

data class Quad<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)
