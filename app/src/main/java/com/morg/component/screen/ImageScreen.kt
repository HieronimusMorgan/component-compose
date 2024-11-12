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
import co.id.nexsoft.component.R
import co.id.nexsoft.component.image.CustomImageComponent
import co.id.nexsoft.component.image.ImageComponent
import co.id.nexsoft.component.util.theme.ComponentSize
import co.id.nexsoft.component.util.theme.ImageSource

@Preview(showBackground = true)
@Composable
fun ImageScreenPreview() {
    ImageScreen(navController = NavController(LocalContext.current))
}

@Composable
fun ImageScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn {
            item {
                CustomImageGolden()
                CustomImageGoldenUrl()
                CustomImageRectangle()
                CustomImageRectangleUrl()
                CustomImageSquare()
                CustomImageSquareUrl()
            }
        }
    }
}

@Composable
fun CustomImageGolden() {
    Text(text = "Image Golden Default")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        items(ComponentSize.entries) { size ->
            CustomImageComponent(
                modifier = Modifier,
                contentDescription = null,
                imageSource = ImageSource.DrawableResource(R.drawable.ic_no_image_grey_component),
                componentSize = size,
                imageComponent = ImageComponent.GOLDEN
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun CustomImageGoldenUrl() {
    Text(text = "Image Golden Url")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        items(ComponentSize.entries) { size ->
            CustomImageComponent(
                modifier = Modifier,
                contentDescription = null,
                imageSource = ImageSource.UrlImage("https://picsum.photos/200/300"),
                componentSize = size,
                imageComponent = ImageComponent.GOLDEN
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun CustomImageRectangle() {
    Text(text = "Image Rectangle Default")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        items(ComponentSize.entries) { size ->
            CustomImageComponent(
                modifier = Modifier,
                contentDescription = null,
                imageSource = ImageSource.DrawableResource(R.drawable.ic_no_image_grey_component),
                componentSize = size,
                imageComponent = ImageComponent.RECTANGLE
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun CustomImageRectangleUrl() {
    Text(text = "Image Rectangle Url")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        items(ComponentSize.entries) { size ->
            CustomImageComponent(
                modifier = Modifier,
                contentDescription = null,
                imageSource = ImageSource.UrlImage("https://picsum.photos/200/300"),
                componentSize = size,
                imageComponent = ImageComponent.RECTANGLE
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun CustomImageSquare() {
    Text(text = "Image Square Default")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        items(ComponentSize.entries) { size ->
            CustomImageComponent(
                modifier = Modifier,
                contentDescription = null,
                imageSource = ImageSource.DrawableResource(R.drawable.ic_no_image_grey_component),
                componentSize = size,
                imageComponent = ImageComponent.SQUARE
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun CustomImageSquareUrl() {
    Text(text = "Image Square Url")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        items(ComponentSize.entries) { size ->
            CustomImageComponent(
                modifier = Modifier,
                contentDescription = null,
                imageSource = ImageSource.UrlImage("https://picsum.photos/200/300"),
                componentSize = size,
                imageComponent = ImageComponent.SQUARE
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

