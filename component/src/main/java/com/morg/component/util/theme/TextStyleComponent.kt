package com.morg.component.util.theme


import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.morg.component.R

// Define the font families

val Heading1: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_light)),
        fontSize = pxToSp(57f),
        lineHeight = pxToSp(64f),
        letterSpacing = pxToSp(-0.25f)
    )

val Heading2: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_light)),
        fontSize = pxToSp(45f),
        lineHeight = pxToSp(52f)
    )

val Heading3: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_regular)),
        fontSize = pxToSp(32f),
        lineHeight = pxToSp(44f)
    )

val Heading4: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_semi_bold)),
        fontSize = pxToSp(32f),
        lineHeight = pxToSp(40f)
    )

val Heading5: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_bold)),
        fontSize = pxToSp(28f),
        lineHeight = pxToSp(36f)
    )

val Heading6: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_bold)),
        fontSize = pxToSp(24f),
        lineHeight = pxToSp(32f)
    )

val TitleLarge: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_bold)),
        fontSize = pxToSp(20f),
        lineHeight = pxToSp(26f)
    )

val TitleMedium: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_bold)),
        fontSize = pxToSp(16f),
        lineHeight = pxToSp(24f),
        letterSpacing = pxToSp(0.1f)
    )

val TitleSmall: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_bold)),
        fontSize = pxToSp(14f),
        lineHeight = pxToSp(20f),
        letterSpacing = pxToSp(0.1f)
    )

val SubtitleLarge: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_semi_bold)),
        fontSize = pxToSp(16f),
        lineHeight = pxToSp(24f),
        letterSpacing = pxToSp(0.1f)
    )

val SubtitleMedium: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_semi_bold)),
        fontSize = pxToSp(14f),
        lineHeight = pxToSp(20f),
        letterSpacing = pxToSp(0.1f)
    )

val SubtitleSmall: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_semi_bold)),
        fontSize = pxToSp(12f),
        lineHeight = pxToSp(16f),
        letterSpacing = pxToSp(0.5f)
    )

val BodyLarge: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = pxToSp(16f),
        lineHeight = pxToSp(24f),
        letterSpacing = pxToSp(0.5f)
    )

val BodyMedium: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = pxToSp(14f),
        lineHeight = pxToSp(20f),
        letterSpacing = pxToSp(0.25f)
    )

val BodySmall: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = pxToSp(12f),
        lineHeight = pxToSp(16f),
        letterSpacing = pxToSp(0.4f)
    )

val CaptionLarge: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = pxToSp(14f),
        lineHeight = pxToSp(20f),
        letterSpacing = pxToSp(0.1f)
    )

val CaptionMedium: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = pxToSp(12f),
        lineHeight = pxToSp(16f),
        letterSpacing = pxToSp(0.5f)
    )

val CaptionSmall: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = pxToSp(11f),
        lineHeight = pxToSp(16f),
        letterSpacing = pxToSp(0.5f)
    )

@Composable
fun pxToDp(px: Float): Dp {
    val density = LocalDensity.current.density
    return Dp(px / density)
}

@Composable
fun pxToSp(px: Float): TextUnit {
    val scaledDensity = LocalDensity.current.fontScale
    return (px / scaledDensity).sp
}