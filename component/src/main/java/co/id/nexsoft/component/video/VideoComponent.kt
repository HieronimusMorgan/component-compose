package co.id.nexsoft.component.video

import android.net.Uri
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import co.id.nexsoft.component.util.theme.ComponentSize
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerView

@Preview(showBackground = true)
@Composable
fun VideoComponentPreview() {
    VideoComponent(
        modifier = Modifier,
        videoUri = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4",
        componentSize = ComponentSize.MEDIUM,
        videoComponent = VideoComponent.GOLDEN,
        autoPlay = true,
        repeat = true
    )
}

@Composable
fun VideoComponent(
    modifier: Modifier = Modifier,
    videoUri: String,
    componentSize: ComponentSize = ComponentSize.MEDIUM,
    videoComponent: VideoComponent = VideoComponent.GOLDEN,
    autoPlay: Boolean = true,
    repeat: Boolean = true
) {
    val videoModifier = modifier.then(
        when (videoComponent) {
            VideoComponent.GOLDEN -> when (componentSize) {
                ComponentSize.SMALL -> Modifier.size(60.dp, 37.08.dp)
                ComponentSize.MEDIUM -> Modifier.size(156.dp, 96.42.dp)
                ComponentSize.LARGE -> Modifier.size(360.dp, 222.5.dp)
            }

            VideoComponent.RECTANGLE -> when (componentSize) {
                ComponentSize.SMALL -> Modifier.size(60.dp, 30.dp)
                ComponentSize.MEDIUM -> Modifier.size(156.dp, 78.dp)
                ComponentSize.LARGE -> Modifier.size(360.dp, 180.dp)
            }

            VideoComponent.SQUARE -> when (componentSize) {
                ComponentSize.SMALL -> Modifier.size(60.dp, 60.dp)
                ComponentSize.MEDIUM -> Modifier.size(156.dp, 156.dp)
                ComponentSize.LARGE -> Modifier.size(360.dp, 360.dp)
            }
        }
    )

    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(Uri.parse(videoUri)))
            playWhenReady = autoPlay
            repeatMode = if (repeat) Player.REPEAT_MODE_ALL else Player.REPEAT_MODE_OFF
            prepare()
        }
    }

    DisposableEffect(Unit) {
        onDispose { exoPlayer.release() }
    }

    AndroidView(
        factory = { PlayerView(context).apply { player = exoPlayer } },
        modifier = videoModifier
    )
}

enum class VideoComponent {
    GOLDEN, RECTANGLE, SQUARE
}
