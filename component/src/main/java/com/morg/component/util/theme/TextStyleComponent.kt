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


/**
 * Provides a TextStyle for Heading1.
 * @return TextStyle with specific font, size, line height, and letter spacing.
 */
val Heading1: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_light)),
        fontSize = pxToSp(57f),
        lineHeight = pxToSp(64f),
        letterSpacing = pxToSp(-0.25f)
    )

/**
 * Provides a TextStyle for Heading2.
 * @return TextStyle with specific font, size, and line height.
 */
val Heading2: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_light)),
        fontSize = pxToSp(45f),
        lineHeight = pxToSp(52f)
    )

/**
 * Provides a TextStyle for Heading3.
 * @return TextStyle with specific font, size, and line height.
 */
val Heading3: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_regular)),
        fontSize = pxToSp(32f),
        lineHeight = pxToSp(44f)
    )

/**
 * Provides a TextStyle for Heading4.
 * @return TextStyle with specific font, size, and line height.
 */
val Heading4: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_semi_bold)),
        fontSize = pxToSp(32f),
        lineHeight = pxToSp(40f)
    )

/**
 * Provides a TextStyle for Heading5.
 * @return TextStyle with specific font, size, and line height.
 */
val Heading5: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_bold)),
        fontSize = pxToSp(28f),
        lineHeight = pxToSp(36f)
    )

/**
 * Provides a TextStyle for Heading6.
 * @return TextStyle with specific font, size, and line height.
 */
val Heading6: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_bold)),
        fontSize = pxToSp(24f),
        lineHeight = pxToSp(32f)
    )

/**
 * Provides a TextStyle for TitleLarge.
 * @return TextStyle with specific font, size, and line height.
 */
val TitleLarge: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_bold)),
        fontSize = pxToSp(20f),
        lineHeight = pxToSp(26f)
    )

/**
 * Provides a TextStyle for TitleMedium.
 * @return TextStyle with specific font, size, line height, and letter spacing.
 */
val TitleMedium: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_bold)),
        fontSize = pxToSp(16f),
        lineHeight = pxToSp(24f),
        letterSpacing = pxToSp(0.1f)
    )

/**
 * Provides a TextStyle for TitleSmall.
 * @return TextStyle with specific font, size, line height, and letter spacing.
 */
val TitleSmall: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_bold)),
        fontSize = pxToSp(14f),
        lineHeight = pxToSp(20f),
        letterSpacing = pxToSp(0.1f)
    )

/**
 * Provides a TextStyle for SubtitleLarge.
 * @return TextStyle with specific font, size, line height, and letter spacing.
 */
val SubtitleLarge: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_semi_bold)),
        fontSize = pxToSp(16f),
        lineHeight = pxToSp(24f),
        letterSpacing = pxToSp(0.1f)
    )

/**
 * Provides a TextStyle for SubtitleMedium.
 * @return TextStyle with specific font, size, line height, and letter spacing.
 */
val SubtitleMedium: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_semi_bold)),
        fontSize = pxToSp(14f),
        lineHeight = pxToSp(20f),
        letterSpacing = pxToSp(0.1f)
    )

/**
 * Provides a TextStyle for SubtitleSmall.
 * @return TextStyle with specific font, size, line height, and letter spacing.
 */
val SubtitleSmall: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_semi_bold)),
        fontSize = pxToSp(12f),
        lineHeight = pxToSp(16f),
        letterSpacing = pxToSp(0.5f)
    )

/**
 * Provides a TextStyle for BodyLarge.
 * @return TextStyle with specific font, size, line height, and letter spacing.
 */
val BodyLarge: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = pxToSp(16f),
        lineHeight = pxToSp(24f),
        letterSpacing = pxToSp(0.5f)
    )

/**
 * Provides a TextStyle for BodyMedium.
 * @return TextStyle with specific font, size, line height, and letter spacing.
 */
val BodyMedium: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = pxToSp(14f),
        lineHeight = pxToSp(20f),
        letterSpacing = pxToSp(0.25f)
    )

/**
 * Provides a TextStyle for BodySmall.
 * @return TextStyle with specific font, size, line height, and letter spacing.
 */
val BodySmall: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = pxToSp(12f),
        lineHeight = pxToSp(16f),
        letterSpacing = pxToSp(0.4f)
    )

/**
 * Provides a TextStyle for CaptionLarge.
 * @return TextStyle with specific font, size, line height, and letter spacing.
 */
val CaptionLarge: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = pxToSp(14f),
        lineHeight = pxToSp(20f),
        letterSpacing = pxToSp(0.1f)
    )

/**
 * Provides a TextStyle for CaptionMedium.
 * @return TextStyle with specific font, size, line height, and letter spacing.
 */
val CaptionMedium: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = pxToSp(12f),
        lineHeight = pxToSp(16f),
        letterSpacing = pxToSp(0.5f)
    )

/**
 * Provides a TextStyle for CaptionSmall.
 * @return TextStyle with specific font, size, line height, and letter spacing.
 */
val CaptionSmall: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = pxToSp(11f),
        lineHeight = pxToSp(16f),
        letterSpacing = pxToSp(0.5f)
    )

/**
 * Converts pixels to Dp.
 * @param px The pixel value to convert.
 * @return The corresponding Dp value.
 */
@Composable
fun pxToDp(px: Float): Dp {
    val density = LocalDensity.current.density
    return Dp(px / density)
}

/**
 * Converts pixels to Sp.
 * @param px The pixel value to convert.
 * @return The corresponding Sp value.
 */
@Composable
fun pxToSp(px: Float): TextUnit {
    val scaledDensity = LocalDensity.current.fontScale
    return (px / scaledDensity).sp
}