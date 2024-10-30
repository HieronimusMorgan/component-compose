package com.morg.component.util.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Object that provides predefined radius values for UI components.
 * Each radius value is represented as a Dp (density-independent pixel).
 */
object RadiusComponent {
    /**
     * Extra extra extra small radius value (2.dp).
     */
    val Radius3Xs: Dp
        @Composable get() = 2.dp

    /**
     * Extra extra small radius value (4.dp).
     */
    val Radius2Xs: Dp
        @Composable get() = 4.dp

    /**
     * Extra small radius value (6.dp).
     */
    val RadiusXs: Dp
        @Composable get() = 6.dp

    /**
     * Small radius value (8.dp).
     */
    val RadiusSm: Dp
        @Composable get() = 8.dp

    /**
     * Medium radius value (10.dp).
     */
    val RadiusMd: Dp
        @Composable get() = 10.dp

    /**
     * Large radius value (12.dp).
     */
    val RadiusLg: Dp
        @Composable get() = 12.dp

    /**
     * Extra large radius value (14.dp).
     */
    val RadiusXl: Dp
        @Composable get() = 14.dp

    /**
     * Extra extra large radius value (16.dp).
     */
    val Radius2Xl: Dp
        @Composable get() = 16.dp

    /**
     * Extra extra extra large radius value (18.dp).
     */
    val Radius3Xl: Dp
        @Composable get() = 18.dp

    /**
     * Four times extra large radius value (20.dp).
     */
    val Radius4Xl: Dp
        @Composable get() = 20.dp

    /**
     * Five times extra large radius value (22.dp).
     */
    val Radius5Xl: Dp
        @Composable get() = 22.dp

    /**
     * Six times extra large radius value (24.dp).
     */
    val Radius6Xl: Dp
        @Composable get() = 24.dp

    /**
     * Full radius value (9999.dp).
     */
    val Full: Dp
        @Composable get() = 9999.dp
}