package co.id.nexsoft.component.toggle

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import co.id.nexsoft.component.util.theme.CaptionMedium
import co.id.nexsoft.component.util.theme.ComponentSize
import co.id.nexsoft.component.util.theme.ImageSource
import co.id.nexsoft.component.util.theme.SpacingComponent
import co.id.nexsoft.component.util.theme.colorText
import co.id.nexsoft.component.util.theme.setId

@Preview(showBackground = true)
@Composable
fun ToggleExampleScreen() {
    var isToggled by remember { mutableStateOf(false) }

    ToggleComponent(
        isChecked = isToggled,
        onCheckedChange = { isToggled = it },
        onColor = Color.Green,
        offColor = Color.Gray,
        thumbColor = Color.White
    )
}

@Composable
fun ToggleComponent(
    modifier: Modifier = Modifier,
    id: String? = null,
    title: String = "",
    titleStyle: TextStyle = BodyLarge.merge(fontWeight = FontWeight.Bold),
    titleColor: Color = colorText,
    toggleTitle: String = "",
    toggleTitleStyle: TextStyle = BodyLarge,
    toggleTitleColor: Color = colorText,
    componentSize: ComponentSize = ComponentSize.MEDIUM,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onColor: Color = MaterialTheme.colorScheme.primary,
    offColor: Color = Color.Gray,
    thumbColor: Color = Color.White,
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
    modifier.layoutId("toggle_${setId(id, "")}")

    Column(modifier = modifier.fillMaxWidth()) {
        val (heightSwitch, widthSwitch, thumbSize, textFontSize, spacing) = when (componentSize) {
            ComponentSize.SMALL -> Quint(
                SpacingComponent.Md16,
                SpacingComponent.Md28,
                SpacingComponent.Sm12,
                SpacingComponent.Sm12.value.sp,
                SpacingComponent.Sm12
            )

            ComponentSize.MEDIUM -> Quint(
                SpacingComponent.Md20,
                SpacingComponent.Lg36,
                SpacingComponent.Md16,
                SpacingComponent.Sm14.value.sp,
                SpacingComponent.Md16
            )

            ComponentSize.LARGE -> Quint(
                SpacingComponent.Md24,
                SpacingComponent.Lg44,
                SpacingComponent.Md20,
                SpacingComponent.Md16.value.sp,
                SpacingComponent.Md20
            )
        }

        if (title.isNotEmpty()) {
            Text(text = title, style = titleStyle, color = titleColor, fontSize = textFontSize)
            Spacer(modifier = Modifier.height(SpacingComponent.Sm8))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {

            SwitchComponent(
                isChecked = isChecked,
                heightSwitch = heightSwitch,
                widthSwitch = widthSwitch,
                thumbSize = thumbSize,
                onCheckedChange = onCheckedChange,
                onColor = onColor,
                offColor = offColor,
                thumbColor = thumbColor
            )
            Spacer(modifier = Modifier.width(spacing))
            Text(
                text = toggleTitle,
                style = toggleTitleStyle,
                color = toggleTitleColor,
                fontSize = textFontSize
            )
        }

        if (informationText.isNotEmpty()) {
            Spacer(modifier = Modifier.height(spacing))
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
            Spacer(modifier = Modifier.height(spacing))
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
fun SwitchComponent(
    isChecked: Boolean,
    heightSwitch: Dp,
    widthSwitch: Dp,
    thumbSize: Dp,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    onColor: Color = MaterialTheme.colorScheme.primary,
    offColor: Color = Color.Gray,
    thumbColor: Color = Color.White
) {
    Box(
        modifier = modifier
            .width(widthSwitch)
            .height(heightSwitch)
            .clip(RoundedCornerShape(SpacingComponent.Sm12))
            .background(if (isChecked) onColor else offColor)
            .clickable { onCheckedChange(!isChecked) }
            .padding(horizontal = SpacingComponent.Sm2)
    ) {
        Box(
            modifier = Modifier
                .size(thumbSize)
                .background(thumbColor, CircleShape)
                .align(if (isChecked) Alignment.CenterEnd else Alignment.CenterStart)
        )
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

data class Quint<A, B, C, D, E>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E
)

