package co.id.nexsoft.component.util.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * The SpacingComponent object in Kotlin provides predefined spacing values for UI components using Jetpack Compose. Each spacing value is represented as a Dp (density-independent pixel), ensuring consistent spacing across different screen densities.
 * The object defines several spacing values, each with a descriptive name indicating its size. For example, None represents no spacing with a value of 0.dp:
 * ``` kotlin
 * val None: Dp
 *     @Composable get() = 0.dp
 * ```
 *
 * Similarly, other spacing values are defined, such as Sm2 for 2.dp, Sm4 for 4.dp, and so on, up to Lg48 for 48.dp. Each of these values is annotated with @Composable, indicating that they can be used within composable functions.
 * These predefined spacing values help maintain consistency in the UI design by providing a standard set of sizes that can be easily reused across different components. For instance, Sm8 represents a small spacing value of 8.dp:
 * ``` kotlin
 * val Sm8: Dp
 *    @Composable get() = 8.dp
 * ```
 * By using these predefined values, developers can ensure that their UI components have consistent spacing, which contributes to a cohesive and visually appealing design.
 *
 * Object that provides predefined spacing values for UI components.
 * Each spacing value is represented as a Dp (density-independent pixel).
 */
object SpacingComponent {
    /**
     * No spacing (0.dp).
     */
    val None: Dp
        @Composable get() = 0.dp

    /**
     * Small spacing value (1.dp).
     */
    val Sm1: Dp
        @Composable get() = 1.dp

    /**
     * Small spacing value (2.dp).
     */

    val Sm2: Dp
        @Composable get() = 2.dp

    /**
     * Small spacing value (4.dp).
     */
    val Sm4: Dp
        @Composable get() = 4.dp

    /**
     * Small spacing value (6.dp).
     */
    val Sm6: Dp
        @Composable get() = 6.dp

    /**
     * Small spacing value (8.dp).
     */
    val Sm8: Dp
        @Composable get() = 8.dp

    /**
     * Small spacing value (10.dp).
     */
    val Sm10: Dp
        @Composable get() = 10.dp

    /**
     * Small spacing value (12.dp).
     */
    val Sm12: Dp
        @Composable get() = 12.dp

    /**
     * Small spacing value (14.dp).
     */
    val Sm14: Dp
        @Composable get() = 14.dp

    /**
     * Medium spacing value (16.dp).
     */
    val Md16: Dp
        @Composable get() = 16.dp

    /**
     * Medium spacing value (18.dp).
     */
    val Md18: Dp
        @Composable get() = 18.dp

    /**
     * Medium spacing value (20.dp).
     */
    val Md20: Dp
        @Composable get() = 20.dp

    /**
     * Medium spacing value (22.dp).
     */
    val Md22: Dp
        @Composable get() = 22.dp

    /**
     * Medium spacing value (24.dp).
     */
    val Md24: Dp
        @Composable get() = 24.dp

    /**
     * Medium spacing value (26.dp).
     */
    val Md26: Dp
        @Composable get() = 26.dp

    /**
     * Medium spacing value (28.dp).
     */
    val Md28: Dp
        @Composable get() = 28.dp

    /**
     * Large spacing value (32.dp).
     */
    val Lg32: Dp
        @Composable get() = 32.dp

    /**
     * Large spacing value (36.dp).
     */
    val Lg36: Dp
        @Composable get() = 36.dp

    /**
     * Large spacing value (40.dp).
     */
    val Lg40: Dp
        @Composable get() = 40.dp

    /**
     * Large spacing value (44.dp).
     */
    val Lg44: Dp
        @Composable get() = 44.dp

    /**
     * Large spacing value (48.dp).
     */
    val Lg48: Dp
        @Composable get() = 48.dp
}