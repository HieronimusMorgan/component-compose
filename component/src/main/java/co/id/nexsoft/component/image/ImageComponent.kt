package co.id.nexsoft.component.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.id.nexsoft.component.util.theme.ComponentSize
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.morg.component.R

@Preview(showBackground = true)
@Composable
fun ImageComponentPreview() {
    Column(modifier = Modifier.fillMaxWidth()) {
        ImageComponent(componentSize = ComponentSize.SMALL)
        Spacer(modifier = Modifier.height(16.dp))
        ImageComponent(componentSize = ComponentSize.MEDIUM)
        Spacer(modifier = Modifier.height(16.dp))
        ImageComponent(componentSize = ComponentSize.LARGE)
    }
}

@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    url: String? = null,
    drawableId: Int = R.drawable.ic_no_image_grey_component,
    componentSize: ComponentSize = ComponentSize.MEDIUM,
    imageComponent: ImageComponent = ImageComponent.GOLDEN
) {
    val imageModifier = modifier.then(
        when (imageComponent) {
            ImageComponent.GOLDEN -> when (componentSize) {
                ComponentSize.SMALL -> Modifier.size(60.dp, 37.08.dp)
                ComponentSize.MEDIUM -> Modifier.size(156.dp, 96.42.dp)
                ComponentSize.LARGE -> Modifier.size(360.dp, 222.5.dp)
            }

            ImageComponent.RECTANGLE -> when (componentSize) {
                ComponentSize.SMALL -> Modifier.size(60.dp, 30.dp)
                ComponentSize.MEDIUM -> Modifier.size(156.dp, 78.dp)
                ComponentSize.LARGE -> Modifier.size(360.dp, 180.dp)
            }

            ImageComponent.SQUARE -> when (componentSize) {
                ComponentSize.SMALL -> Modifier.size(60.dp, 60.dp)
                ComponentSize.MEDIUM -> Modifier.size(156.dp, 156.dp)
                ComponentSize.LARGE -> Modifier.size(360.dp, 360.dp)
            }
        }
    )

    if (url != null) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .crossfade(true)
                .placeholder(R.drawable.ic_no_image_grey_component)
                .error(R.drawable.ic_no_image_grey_component)
                .transformations(CircleCropTransformation())
                .build(),
            contentDescription = contentDescription,
            modifier = imageModifier,
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.CenterStart
        )
    } else {
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = contentDescription,
            contentScale = ContentScale.FillWidth,
            modifier = imageModifier
        )
    }
}

enum class ImageComponent {
    GOLDEN, RECTANGLE, SQUARE
}