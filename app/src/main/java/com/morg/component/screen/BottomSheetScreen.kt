package com.morg.component.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScaffoldExample() {
    // Create a coroutine scope for handling the bottom sheet expansion/collapse
    val scope = rememberCoroutineScope()

    val sheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.PartiallyExpanded
    )
    // Set up the scaffold state and bottom sheet state
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(sheetState)

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            // Content inside the bottom sheet
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
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
        sheetPeekHeight = 0.dp // Height when the bottom sheet is collapsed
    ) {
        // Main content of the screen
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                scope.launch {
                    if (bottomSheetScaffoldState.bottomSheetState.isVisible) {
                        bottomSheetScaffoldState.bottomSheetState.expand() // Open bottom sheet
                    } else {
                        bottomSheetScaffoldState.bottomSheetState.hide() // Close bottom sheet
                    }
                }
            }) {
                Text("Toggle Bottom Sheet")
            }
        }
    }
}