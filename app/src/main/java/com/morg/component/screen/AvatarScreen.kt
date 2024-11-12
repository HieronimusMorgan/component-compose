package com.morg.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.avatar.AvatarBadge
import co.id.nexsoft.component.avatar.AvatarComponent
import co.id.nexsoft.component.avatar.AvatarGroup
import co.id.nexsoft.component.avatar.AvatarSize
import co.id.nexsoft.component.avatar.AvatarType

@Preview(showBackground = true)
@Composable
fun AvatarScreenPreview() {
    AvatarScreen(navController = NavController(LocalContext.current))
}

@Composable
fun AvatarScreen(navController: NavController) {
    // Use `remember` to store the lists as immutable
    val names = remember {
        listOf(
            "John Doe",
            "Jane Smith",
            "Alice Brown",
            "Bob White",
            "Carol Black",
            "David Green"
        )
    }
    val avatarSizes = remember { AvatarSize.allSizes }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Column {
            AvatarDefault(avatarSizes)
            AvatarInitial(names, avatarSizes)
            AvatarDefaultLegend(avatarSizes)
            AvatarInitialLegend(names, avatarSizes)
            AvatarDefaultNotification(avatarSizes)
            AvatarInitialNotification(names, avatarSizes)
            AvatarDefaultVerified(avatarSizes)
            AvatarInitialVerified(names, avatarSizes)
            AvatarMultipleDefault(avatarSizes)
            AvatarMultipleInitial(names, avatarSizes)
            AvatarGroupDefault(avatarSizes)
            AvatarGroupInitial(names, avatarSizes)
        }
    }
}

@Composable
private fun AvatarDefault(avatarSizes: List<Dp>) {
    Text(text = "Avatar Default")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        items(avatarSizes) { size ->
            AvatarComponent(type = AvatarType.Default, size = size)
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}

@Composable
private fun AvatarInitial(names: List<String>, avatarSizes: List<Dp>) {
    Text(text = "Avatar Initial")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        items(names.zip(avatarSizes)) { (name, size) ->
            AvatarComponent(name = name, type = AvatarType.Initial, size = size)
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}

@Composable
private fun AvatarDefaultLegend(avatarSizes: List<Dp>) {
    Text(text = "Avatar Default Legend")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(avatarSizes) {
            AvatarComponent(
                type = AvatarType.Default, badge = AvatarBadge.Legend, size = it
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}


@Composable
private fun AvatarInitialLegend(names: List<String>, avatarSizes: List<Dp>) {
    Text(text = "Avatar Initial Legend")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(names.zip(avatarSizes)) { (name, size) ->
            AvatarComponent(
                name = name, type = AvatarType.Initial, badge = AvatarBadge.Legend, size = size
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun AvatarDefaultNotification(avatarSizes: List<Dp>) {
    Text(text = "Avatar Default Notification")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(avatarSizes) {
            AvatarComponent(
                type = AvatarType.Default,
                badge = AvatarBadge.Notification,
                notification = "5",
                size = it
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun AvatarInitialNotification(names: List<String>, avatarSizes: List<Dp>) {
    Text(text = "Avatar Initial Notification")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(names.zip(avatarSizes)) { (name, size) ->
            AvatarComponent(
                name = name,
                type = AvatarType.Initial,
                badge = AvatarBadge.Notification,
                notification = "5",
                size = size
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun AvatarDefaultVerified(avatarSizes: List<Dp>) {
    Text(text = "Avatar Default Verified")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(avatarSizes) {
            AvatarComponent(
                type = AvatarType.Default,
                badge = AvatarBadge.Verified,
                size = it
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun AvatarInitialVerified(names: List<String>, avatarSizes: List<Dp>) {
    Text(text = "Avatar Initial Verified")
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(names.zip(avatarSizes)) { (name, size) ->
            AvatarComponent(
                name = name,
                type = AvatarType.Initial,
                badge = AvatarBadge.Verified,
                size = size
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun AvatarMultipleDefault(avatarSizes: List<Dp>) {
    Text(text = "Avatar Multiple Default")
    Spacer(modifier = Modifier.height(8.dp))
    Column {
        avatarSizes.forEach {
            AvatarComponent(
                type = AvatarType.Default,
                size = it,
                group = AvatarGroup.Multiple,
                avatarCounter = 3
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun AvatarMultipleInitial(names: List<String>, avatarSizes: List<Dp>) {
    Text(text = "Avatar Multiple Initial")
    Spacer(modifier = Modifier.height(8.dp))
    Column {
        avatarSizes.forEach {
            AvatarComponent(
                type = AvatarType.Initial, size = it,
                group = AvatarGroup.Multiple,
                avatarCounter = 3,
                listName = names
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun AvatarGroupDefault(avatarSizes: List<Dp>) {
    Text(text = "Avatar Group Default")
    Spacer(modifier = Modifier.height(8.dp))
    Column {
        avatarSizes.forEach {
            AvatarComponent(
                type = AvatarType.Default,
                size = it,
                group = AvatarGroup.Group,
                avatarCounter = 3
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun AvatarGroupInitial(names: List<String>, avatarSizes: List<Dp>) {
    Text(text = "Avatar Group Initial")
    Spacer(modifier = Modifier.height(8.dp))
    Column {
        avatarSizes.forEach {
            AvatarComponent(
                type = AvatarType.Initial, size = it,
                group = AvatarGroup.Group,
                avatarCounter = 3,
                listName = names
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}
