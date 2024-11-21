package co.id.nexsoft.component.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun BottomSheetComponentPreview() {
    var showBottomSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
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
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetComponent(
    modifier: Modifier = Modifier,
    showBottomSheet: Boolean,
    skipPartiallyExpanded: Boolean = false,
    onDismiss: () -> Unit = {},
    content: @Composable () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = skipPartiallyExpanded,
    )
    val coroutineScope = rememberCoroutineScope()

    // Show the sheet when requested
    LaunchedEffect(showBottomSheet) {
        if (showBottomSheet) {
            coroutineScope.launch {
                sheetState.show()
            }
        } else {
            coroutineScope.launch {
                sheetState.hide()
            }
        }
    }
    ModalBottomSheet(
        modifier = modifier,
        sheetState = sheetState,
        onDismissRequest = onDismiss
    ) {
        content()
    }
}
