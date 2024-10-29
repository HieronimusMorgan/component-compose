package com.morg.component.avatar

import androidx.annotation.ColorInt
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.graphics.ColorUtils
import com.morg.component.util.theme.BodyMedium
import com.morg.component.util.theme.SpacingComponent
import kotlin.math.absoluteValue

@Preview(showBackground = true)
@Composable
fun AvatarComponentPreview() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {

            Text(text = "Avatar Component Default and Initial")
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                AvatarComponent(
                    name = "John Doe",
                    type = AvatarType.Default,
                )
                Spacer(modifier = Modifier.width(2.dp))
                AvatarComponent(
                    name = "Mill West",
                    type = AvatarType.Initial,
                )
                Spacer(modifier = Modifier.width(2.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Avatar Component Group and Multiple")
            Spacer(modifier = Modifier.height(8.dp))
            AvatarComponent(
                names = listOf("John WE", "asdd", "asdasd"),
                type = AvatarType.Initial,
                group = AvatarGroup.Group
            )
            Spacer(modifier = Modifier.height(8.dp))
            AvatarComponent(
                names = listOf("John WE", "asdd", "asdasd"),
                avatarCounter = 5,
                type = AvatarType.Initial,
                group = AvatarGroup.Multiple
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Avatar Component Badge")
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                AvatarComponent(
                    name = "John Doe", type = AvatarType.Default, badge = AvatarBadge.Legend
                )
                Spacer(modifier = Modifier.width(SpacingComponent.Sm2))
                AvatarComponent(
                    name = "Mill West", type = AvatarType.Initial, badge = AvatarBadge.Verified
                )
                Spacer(modifier = Modifier.width(2.dp))
                AvatarComponent(
                    name = "John Doe",
                    type = AvatarType.Default,
                    badge = AvatarBadge.Notification,
                    notification = "5"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}

@Composable
fun AvatarComponent(
    modifier: Modifier = Modifier,
    name: String? = null,
    size: Dp = AvatarSize.Medium,
    textStyle: TextStyle = BodyMedium,
    icon: ImageVector = Icons.Filled.Person,
    type: AvatarType = AvatarType.Default,
    names: List<String>? = null,
    avatarCounter: Int = 0,
    badge: AvatarBadge? = null,
    group: AvatarGroup? = null,
    isSelected: Boolean = false,
    notification: String? = null,
) {
    when (group) {
        AvatarGroup.Group -> GroupAvatar(modifier, size, textStyle, type, names ?: emptyList())
        AvatarGroup.Multiple -> MultipleAvatar(
            modifier,
            size,
            textStyle,
            type,
            avatarCounter,
            names ?: emptyList()
        )

        else -> {
            when (type) {
                AvatarType.Default -> DefaultAvatar(
                    modifier,
                    size,
                    icon,
                    badge,
                    isSelected,
                    notification
                )

                AvatarType.Initial -> name?.let {
                    InitialAvatar(it, modifier, size, textStyle, badge, isSelected, notification)
                }
            }
        }
    }
}

@Composable
fun MultipleAvatar(
    modifier: Modifier,
    size: Dp,
    textStyle: TextStyle,
    type: AvatarType,
    avatarCounter: Int,
    names: List<String>
) {
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .height(size)
    ) {
        for (index in 0 until avatarCounter) {
            Box(
                modifier = Modifier
                    .zIndex(index.toFloat())
                    .offset(x = (-(size.value / 2.5) * index).dp)
            ) {
                if (type == AvatarType.Default || index >= names.size || names[index].isEmpty()) {
                    DefaultAvatar(modifier, size, Icons.Filled.Person)
                } else {
                    InitialAvatar(names[index], modifier, size, textStyle)
                }
            }
        }
    }
}

@Composable
fun GroupAvatar(
    modifier: Modifier,
    size: Dp,
    textStyle: TextStyle,
    type: AvatarType,
    names: List<String>
) {
    Row {
        for (index in 0 until 3) {
            if (type == AvatarType.Default || index >= names.size || names[index].isEmpty()) {
                DefaultAvatar(modifier, size, Icons.Filled.Person)
            } else {
                InitialAvatar(names[index], modifier, size, textStyle)
            }
            Spacer(modifier = Modifier.width(1.dp))
        }
    }
}

@Composable
fun DefaultAvatar(
    modifier: Modifier,
    size: Dp,
    icon: ImageVector,
    badge: AvatarBadge? = null,
    isSelected: Boolean = false,
    notification: String? = null,
) {
    Box(modifier.size(size), contentAlignment = Alignment.Center) {
        Canvas(modifier = modifier.size(size)) {
            drawCircle(SolidColor(Color(0XFFE4E6E7)))
        }
        Image(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(color = Color(0XFFAEB4B7))
        )

        if (isSelected) {
            BadgeBox(modifier = Modifier.align(Alignment.BottomEnd), size, Icons.Filled.Check)
        }

        badge?.let {
            when (it) {
                AvatarBadge.Legend -> BadgeBox(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    size,
                    null,
                    isLegend = true
                )

                AvatarBadge.Verified -> BadgeBox(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    size,
                    Icons.Filled.Check
                )

                else -> NotificationBadge(
                    modifier = Modifier.align(Alignment.TopEnd),
                    size,
                    notification
                )
            }
        }
    }
}

@Composable
fun InitialAvatar(
    name: String = "",
    modifier: Modifier,
    size: Dp,
    textStyle: TextStyle,
    badge: AvatarBadge? = null,
    isSelected: Boolean = false,
    notification: String? = null,
) {
    val initials = getInitials(name)
    val color = remember(name) { Color(initials.toHslColor()) }

    Box(modifier.size(size), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(SolidColor(color))
        }

        Text(text = initials, style = textStyle, color = Color.White)

        if (isSelected) {
            BadgeBox(modifier = Modifier.align(Alignment.BottomEnd), size, Icons.Filled.Check)
        }

        badge?.let {
            when (it) {
                AvatarBadge.Legend -> BadgeBox(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    size,
                    null,
                    isLegend = true
                )

                AvatarBadge.Verified -> BadgeBox(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    size,
                    Icons.Filled.Check
                )

                else -> NotificationBadge(
                    modifier = Modifier.align(Alignment.TopEnd),
                    size,
                    notification
                )
            }
        }
    }
}

@Composable
fun BadgeBox(modifier: Modifier, size: Dp, icon: ImageVector?, isLegend: Boolean = false) {
    Box(
        modifier = modifier
            .size(if (isLegend) size / 4 else size / 3)
            .background(Color(0xFF4CAF50), shape = CircleShape)
    ) {
        icon?.let {
            Image(
                modifier = Modifier.padding(SpacingComponent.Sm2),
                imageVector = it,
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = null
            )
        }
    }
}

@Composable
fun NotificationBadge(modifier: Modifier, size: Dp, notification: String?) {
    Box(
        modifier = modifier
            .size(size / 3)
            .background(Color.Red, shape = CircleShape)
    ) {
        Text(
            text = notification?.trim() ?: "",
            fontSize = (size.value / 5).sp,
            style = TextStyle(color = Color.White),
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            textAlign = TextAlign.Center
        )
    }
}

private fun getInitials(name: String): String {
    val names = name.split(" ")
    return if (names.size > 1) {
        (names[0].take(1) + names[1].take(1)).uppercase()
    } else {
        names[0].take(1).uppercase()
    }
}

@ColorInt
fun String.toHslColor(saturation: Float = 0.5f, lightness: Float = 0.4f): Int {
    val hue = fold(0) { acc, char -> char.code + acc * 37 } % 360
    return ColorUtils.HSLToColor(floatArrayOf(hue.absoluteValue.toFloat(), saturation, lightness))
}

enum class AvatarType {
    Default, Initial
}

enum class AvatarBadge {
    Legend, Verified, Notification,
}

enum class AvatarGroup {
    Group, Multiple,
}

object AvatarSize {
    val ExtraSmall = 24.dp
    val Small = 32.dp
    val Medium = 40.dp
    val Large = 48.dp
    val ExtraLarge = 64.dp
    val ExtraLarge2 = 80.dp
}