package com.morg.component.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.util.theme.ComponentSize
import co.id.nexsoft.component.video.CustomVideoComponent
import co.id.nexsoft.component.video.VideoComponent


@Preview(showBackground = false)
@Composable
fun VideoScreenPreview() {
    VideoScreen(navController = NavController(LocalContext.current))
}

@Composable
fun VideoScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn {
            item {
                CustomVideoGolden()
                CustomVideoRectangle()
                CustomVideoSquare()
            }
        }
    }
}

@Composable
fun CustomVideoGolden() {
    Text(text = "Video Golden Default")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        items(ComponentSize.entries) { size ->
            CustomVideoComponent(
                modifier = Modifier,
                videoUri = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4",
                componentSize = size,
                videoComponent = VideoComponent.GOLDEN,
                autoPlay = false,
                repeat = false
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun CustomVideoRectangle() {
    Text(text = "Video Rectangle Default")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        items(ComponentSize.entries) { size ->
            CustomVideoComponent(
                modifier = Modifier,
                videoUri = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4",
                componentSize = size,
                videoComponent = VideoComponent.RECTANGLE,
                autoPlay = false,
                repeat = false
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun CustomVideoSquare() {
    Text(text = "Video Square Default")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        items(ComponentSize.entries) { size ->
            CustomVideoComponent(
                modifier = Modifier,
                videoUri = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4",
                componentSize = size,
                videoComponent = VideoComponent.SQUARE,
                autoPlay = false,
                repeat = false
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}
