package com.morg.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun CustomAlertDialogDemo() {
    var showDialog by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        // Button to trigger the custom dialog
        Button(onClick = { showDialog = true }) {
            Text("Show Custom Dialog")
        }

        // Display the custom dialog with a custom body
        if (showDialog) {
            CustomAlertDialog(title = "Custom Dialog with Custom Body",
                confirmButtonText = "Accept",
                dismissButtonText = "Cancel",
                onConfirm = {
                    // Handle confirm action
                    showDialog = false
                },
                onDismiss = {
                    // Handle dismiss action
                    showDialog = false
                }) {
                // Custom content for the body
                Text(
                    text = "Would you like to receive notifications?",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = isChecked, onCheckedChange = { isChecked = it })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = if (isChecked) "Enabled" else "Disabled")
                }
            }
        }
    }
}

@Composable
fun CustomAlertDialog(
    title: String,
    confirmButtonText: String = "Confirm",
    dismissButtonText: String = "Dismiss",
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    titleColor: Color = MaterialTheme.colorScheme.primary,
    buttonTextColor: Color = MaterialTheme.colorScheme.primary,
    content: @Composable ColumnScope.() -> Unit
) {
    AlertDialog(onDismissRequest = { onDismiss() }, confirmButton = {
        TextButton(onClick = { onConfirm() }) {
            Text(confirmButtonText, color = buttonTextColor)
        }
    }, dismissButton = {
        TextButton(onClick = { onDismiss() }) {
            Text(dismissButtonText, color = buttonTextColor)
        }
    }, title = {
        Text(
            modifier = Modifier,
            text = title,
            color = titleColor,
            style = MaterialTheme.typography.titleLarge
        )
    }, text = {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), content = content
        )
    }, modifier = Modifier.background(backgroundColor, shape = MaterialTheme.shapes.medium)
    )
}

