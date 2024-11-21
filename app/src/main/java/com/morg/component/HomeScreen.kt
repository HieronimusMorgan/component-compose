package com.morg.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.bottomsheet.BottomSheetComponent
import co.id.nexsoft.component.util.theme.BodyLarge
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current), onItemClicked = {})
}

@Composable
fun HomeScreen(navController: NavController, onItemClicked: (String) -> Unit) {
    var showBottomSheet by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        item {
            Button(
                onClick = { showBottomSheet = true }
            ) {
                Text("Display Partial Bottom Sheet")
            }

            if (showBottomSheet) {
                BottomSheetComponent(
                    modifier = Modifier,
                    showBottomSheet = showBottomSheet,
                    onDismiss = { showBottomSheet = false },
                ) {
                    Text(
                        "This is the Bottom Sheet",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            Screen.entries.forEach { screen ->
                if (screen.route == "home") {
                    return@forEach
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClicked(screen.label) // Update title with label
                        navController.navigate(screen.route) // Navigate using the route
                    }) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(16.dp)
                                .weight(1f),
                            text = screen.label,
                            style = BodyLarge,
                            fontWeight = FontWeight.Bold,
                        )
                        Image(
                            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                            contentDescription = null
                        )

                    }
                    HorizontalDivider()
                }
            }
        }
    }
}

enum class Screen(val label: String, val route: String) {
    HOME("Home", "home"),
    AVATAR("Avatar", "avatar"),
    BUTTON("Button", "button"),
    BUTTON_ICON("Button Icon", "button_icon"),
    CARD("Card", "card"),
    CHECKBOX("Checkbox", "checkbox"),
    EXPANSION("Expansion", "expansion"),
    IMAGE("Image", "image"),
    INFORMATION_CARD("Information Card", "information_card"),
    OTP_VERIFICATION("OTP Verification", "otp_verification"),
    RADIO("Radio", "radio"),
    RATING("Rating", "rating"),
    STEPPER("Stepper", "stepper"),
    STEP("Step", "step"),
    TEXT_FIELD("Text Field", "text_field"),
    TOGGLE("Toggle", "toggle"),
    VIDEO("Video", "video")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScaffoldExample() {
    val scope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            // Content inside the bottom sheet
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .heightIn(max = 400.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("This is the Bottom Sheet")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    scope.launch { bottomSheetScaffoldState.bottomSheetState.hide() }
                }) {
                    Text("Close Bottom Sheet")
                }
            }
        },
        sheetPeekHeight = 56.dp, // The height when the sheet is collapsed
    ) {
        // Main content of the scaffold
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                scope.launch { bottomSheetScaffoldState.bottomSheetState.expand() }
            }) {
                Text("Open Bottom Sheet")
            }
        }
    }
}