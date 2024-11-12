package co.id.nexsoft.component.util.theme

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ImageSource {
    data class VectorImage(val imageVector: ImageVector) : ImageSource()
    data class DrawableResource(@DrawableRes val resId: Int) : ImageSource()
    data class UrlImage(val url: String) : ImageSource()
}
