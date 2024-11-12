package co.id.nexsoft.component.bottomsheet


import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.id.nexsoft.component.R
import coil.compose.AsyncImage
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.CameraMoveStartedReason
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfficialMaterial3DemoScreen() {
    val sheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.PartiallyExpanded
    )
    val scaffoldState = rememberBottomSheetScaffoldState(sheetState)

    BoxWithConstraints {
        val layoutHeightPx = constraints.maxHeight

        val density = LocalDensity.current
        val bottomPadding by remember(layoutHeightPx) {
            derivedStateOf {
                val sheetVisibleHeightPx = layoutHeightPx - sheetState.requireOffset()
                with(density) { sheetVisibleHeightPx.roundToInt().toDp() }
            }
        }

        BottomSheetScaffold(
            sheetPeekHeight = 100.dp,
            scaffoldState = scaffoldState,
            sheetContent = {
                BottomSheetContent()
            },
            content = {
                val isBottomSheetMoving by remember {
                    derivedStateOf { sheetState.currentValue != sheetState.targetValue }
                }
                MapScreenContent(
                    bottomPadding = bottomPadding,
                    isBottomSheetMoving = isBottomSheetMoving,
                    layoutHeight = maxHeight
                )
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}


enum class BottomSheetContentSize { Small, Medium, Large }

@Composable
fun BottomSheetContent(
    modifier: Modifier = Modifier,
    userScrollEnabled: Boolean = true,
    size: BottomSheetContentSize = BottomSheetContentSize.Medium
) {
    val itemCount = remember(size) {
        when (size) {
            BottomSheetContentSize.Small -> 0
            BottomSheetContentSize.Medium -> 2
            BottomSheetContentSize.Large -> pointsOfInterest.size
        }
    }
    LazyColumn(
        userScrollEnabled = userScrollEnabled,
        modifier = modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
    ) {
        item {
            Header(Modifier.padding(bottom = 16.dp))
        }

        items(itemCount) { i ->
            PointOfInterestItem(
                pointOfInterest = pointsOfInterest[i],
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Composable
private fun Header(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(text = "San Francisco, California", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))
        Text(text = "Iconic places", style = MaterialTheme.typography.titleMedium)
    }
}

@Composable
private fun PointOfInterestItem(
    pointOfInterest: PointOfInterest,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 1.dp,
        modifier = modifier
    ) {
        Column {
            AsyncImage(
                model = pointOfInterest.photoUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(190.dp)
            )
            Column(Modifier.padding(16.dp)) {
                Text(text = pointOfInterest.name, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = pointOfInterest.license,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

private data class PointOfInterest(val name: String, val photoUrl: String, val license: String)

private val pointsOfInterest = listOf(
    PointOfInterest(
        name = "Golden Gate",
        photoUrl = "https://images.unsplash.com/photo-1610312278520-bcc893a3ff1d?q=80&w=3494&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        // Photo by Varun Yadav on Unsplash. https://unsplash.com/photos/golden-gate-bridge-san-francisco-california-QhYTCG3CTeI
        license = "Photo by Varun Yadav on Unsplash"
    ),
    PointOfInterest(
        name = "The Painted Ladies",
        photoUrl = "https://images.unsplash.com/photo-1522735555435-a8fe18da2089?q=80&w=3540&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        // Photo by Aaron Kato on Unsplash. https://unsplash.com/photos/white-and-brown-2-storey-houses-with-vehicles-in-front-during-daytime-zcoDYal9GkQ
        license = "Photo by Aaron Kato on Unsplash"
    ),
    PointOfInterest(
        name = "Salesforce Tower",
        photoUrl = "https://images.unsplash.com/photo-1558623869-d6f8763a24f9?q=80&w=3522&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        // Photo by Denys Nevozhai on Unsplash. https://unsplash.com/photos/aerial-view-of-city-during-nighttime-wgtJfd2Jhnk
        license = "Photo by Denys Nevozhai on Unsplash"
    ),
    PointOfInterest(
        name = "Lombard Street",
        photoUrl = "https://plus.unsplash.com/premium_photo-1673483585905-439b19e0d30a?q=80&w=3348&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        // Photo by Casey Horner on Unsplash+. https://unsplash.com/photos/an-aerial-view-of-a-city-with-a-river-running-through-it-tQicpDWhIzk
        license = "Photo by Casey Horner on Unsplash+"
    ),
)


private const val DefaultMapZoom = 13f
private val SanFranciscoLocation = LatLng(37.77446, -122.42064)
private val MapUiOffsetLimit = 100.dp

@Composable
fun MapScreenContent(
    modifier: Modifier = Modifier,
    bottomPadding: Dp = 0.dp,
    isBottomSheetMoving: Boolean = false,
    layoutHeight: Dp = Dp.Unspecified,
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(SanFranciscoLocation, DefaultMapZoom)
    }

    val maxBottomPadding = remember(layoutHeight) { layoutHeight - MapUiOffsetLimit }
    val mapPadding = rememberMapPadding(bottomPadding, maxBottomPadding)

    AdjustedCameraPositionEffect(
        camera = cameraPositionState,
        isBottomSheetMoving = isBottomSheetMoving,
        bottomPadding = mapPadding.calculateBottomPadding(),
    )

    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        uiSettings = rememberMapUiSettings(),
        properties = rememberMapProperties(),
        contentPadding = mapPadding
    )
}

@Composable
private fun AdjustedCameraPositionEffect(
    camera: CameraPositionState,
    isBottomSheetMoving: Boolean,
    bottomPadding: Dp,
) {
    var cameraLocation by remember { mutableStateOf(camera.position.target) }
    LaunchedEffect(camera.isMoving, camera.cameraMoveStartedReason) {
        if (!camera.isMoving && camera.cameraMoveStartedReason == CameraMoveStartedReason.GESTURE) {
            cameraLocation = camera.position.target
        }
    }

    var isCameraInitialized by remember { mutableStateOf(false) }
    val density = LocalDensity.current
    LaunchedEffect(isBottomSheetMoving) {
        if (isBottomSheetMoving) return@LaunchedEffect

        // The map does not respect the initial bottom padding value. The CameraPositionState in
        // this case returns the camera location as if the padding was not set. Therefore, the
        // camera must be manually shifted according to the initial padding value.
        if (!isCameraInitialized) {
            isCameraInitialized = true
            val verticalShiftPx = with(density) { bottomPadding.toPx() / 2 }
            val update = CameraUpdateFactory.scrollBy(0f, verticalShiftPx)
            camera.animate(update)
        } else {
            val update = CameraUpdateFactory.newLatLng(cameraLocation)
            camera.animate(update)
        }
    }
}

@Composable
private fun rememberMapPadding(bottomPadding: Dp, maxBottomPadding: Dp): PaddingValues {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    return if (isPortrait) {
        rememberPortraitMapPadding(bottomPadding, maxBottomPadding)
    } else {
        remember { PaddingValues() }
    }
}

@Composable
private fun rememberPortraitMapPadding(bottomPadding: Dp, maxBottomPadding: Dp): PaddingValues {
    return remember(bottomPadding, maxBottomPadding) {
        PaddingValues(
            start = 16.dp,
            end = 16.dp,
            bottom = bottomPadding.takeIf { it < maxBottomPadding } ?: maxBottomPadding
        )
    }
}

@Composable
private fun rememberMapUiSettings(): MapUiSettings {
    return remember {
        MapUiSettings(
            compassEnabled = true,
            indoorLevelPickerEnabled = true,
            mapToolbarEnabled = false,
            myLocationButtonEnabled = false,
            rotationGesturesEnabled = false,
            scrollGesturesEnabled = true,
            scrollGesturesEnabledDuringRotateOrZoom = false,
            tiltGesturesEnabled = false,
            zoomControlsEnabled = false,
            zoomGesturesEnabled = true,
        )
    }
}

@Composable
private fun rememberMapProperties(): MapProperties {
    val context = LocalContext.current
    val isDarkTheme = isSystemInDarkTheme()
    return remember(isDarkTheme) {
        val mapStyleOptions = if (isDarkTheme) {
            mapStyleDarkOptions(context)
        } else {
            mapStyleOptions(context)
        }
        MapProperties(mapStyleOptions = mapStyleOptions)
    }
}

fun mapStyleOptions(context: Context): MapStyleOptions {
    return MapStyleOptions.loadRawResourceStyle(context, R.raw.map_style)
}

fun mapStyleDarkOptions(context: Context): MapStyleOptions {
    return MapStyleOptions.loadRawResourceStyle(context, R.raw.map_style_dark)
}