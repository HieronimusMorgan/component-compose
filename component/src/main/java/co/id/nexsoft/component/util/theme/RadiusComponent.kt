package co.id.nexsoft.component.util.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * The RadiusComponent object in Kotlin provides predefined radius values for UI components using Jetpack Compose. Each radius value is represented as a Dp (density-independent pixel), which ensures consistent sizing across different screen densities.
 *
 * The object defines several radius values, each with a descriptive name indicating its size. For example, Radius3Xs represents an extra extra extra small radius value of 2.dp:
 * ``` kotlin
 * val Radius3Xs: Dp
 *    @Composable get() = 2.dp
 *```
 * Similarly, other radius values are defined, such as Radius2Xs for 4.dp, RadiusXs for 6.dp, and so on, up to Radius6Xl for 24.dp. Each of these values is annotated with @Composable, indicating that they can be used within composable functions.
 *
 * Additionally, the Full radius value is defined as 9999.dp, which can be used to create fully rounded components:
 * ``` kotlin
 * val Full: Dp
 *     @Composable get() = 9999.dp
 * ```
 * These predefined radius values help maintain consistency in the UI design by providing a standard set of sizes that can be easily reused across different components.
 *
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