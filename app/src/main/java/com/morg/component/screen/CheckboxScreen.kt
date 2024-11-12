package com.morg.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.id.nexsoft.component.checkbox.CheckboxComponent
import co.id.nexsoft.component.util.theme.ComponentSize

@Preview(showBackground = true)
@Composable
fun CheckboxScreenPreview() {
    CheckboxScreen(navController = NavController(LocalContext.current))
}

@Composable
fun CheckboxScreen(navController: NavController) {
    val options = remember {
        mutableStateMapOf(
            "Option 1" to false,
            "Option 2" to false,
            "Option 3" to false
        )
    }

    // Function to handle changes to checkbox states
    val onCheckedChange: (Map<String, Boolean>) -> Unit = { updatedOptions ->
        options.putAll(updatedOptions) // Update the snapshot-backed map
    }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Column {

            ComponentSize.entries.forEach {
                CheckboxComponent(
                    title = "Choose an Option",
                    options = options,
                    componentSize = it,
                    onCheckedChange = onCheckedChange,
                    informationText = "Select only one option to proceed.",
                    errorText = if (options.count { it.value } != 1) "Please select exactly one option." else ""
                )
            }

            ComponentSize.entries.forEach {
                CheckboxComponent(
                    title = "Choose an Option",
                    options = options,
                    componentSize = it,
                    verticalAlignment = true,
                    onCheckedChange = onCheckedChange,
                    informationText = "Select only one option to proceed.",
                    errorText = if (options.count { it.value } != 1) "Please select exactly one option." else ""
                )
            }


        }
    }
}