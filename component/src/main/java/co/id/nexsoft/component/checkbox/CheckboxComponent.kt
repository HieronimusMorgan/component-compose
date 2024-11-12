package co.id.nexsoft.component.checkbox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.id.nexsoft.component.util.theme.ComponentSize
import co.id.nexsoft.component.util.theme.setId

@Preview(showBackground = true)
@Composable
fun CheckboxComponentPreview() {
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

    // UI for the CheckboxComponent
    CheckboxComponent(
        title = "Choose an Option",
        options = options,
        componentSize = ComponentSize.MEDIUM,
        onCheckedChange = onCheckedChange,
        informationText = "Select only one option to proceed.",
        errorText = if (options.count { it.value } != 1) "Please select exactly one option." else ""
    )
}

@Composable
fun CheckboxComponent(
    modifier: Modifier = Modifier,
    id: String? = null,
    title: String = "",
    titleStyle: TextStyle = MaterialTheme.typography.titleMedium,
    titleColor: Color = Color.Black,
    checkedColor: Color = Color.Blue,
    uncheckedColor: Color = Color.Gray,
    disabledColor: Color = Color.LightGray,
    verticalAlignment: Boolean = false,
    componentSize: ComponentSize = ComponentSize.MEDIUM,
    options: MutableMap<String, Boolean>, // MutableMap to toggle checkboxes
    onCheckedChange: (Map<String, Boolean>) -> Unit,
    informationText: String = "",
    informationTextStyle: TextStyle = MaterialTheme.typography.bodySmall,
    informationTextColor: Color = Color.Gray,
    errorText: String = "",
    errorTextStyle: TextStyle = MaterialTheme.typography.bodySmall,
    errorTextColor: Color = MaterialTheme.colorScheme.error
) {
    // Track the state of each checkbox
    val checkedOptions by remember { mutableStateOf(options) }
    var error by remember { mutableStateOf(errorText) }
    modifier.layoutId("checkbox_${setId(id, "")}")
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        // Title
        if (title.isNotEmpty()) {
            Text(text = title, style = titleStyle, color = titleColor)
            Spacer(modifier = Modifier.height(8.dp))
        }

        // Display checkboxes in a row or column based on verticalAlignment
        if (verticalAlignment) {
            checkedOptions.forEach { (label, isChecked) ->
                CheckboxOption(
                    modifier = Modifier.padding(start = 4.dp),
                    isChecked = isChecked,
                    label = label,
                    checkSize = when (componentSize) {
                        ComponentSize.SMALL -> 16.dp
                        ComponentSize.MEDIUM -> 20.dp
                        ComponentSize.LARGE -> 24.dp
                    },
                    textFontSize = when (componentSize) {
                        ComponentSize.SMALL -> 12.sp
                        ComponentSize.MEDIUM -> 14.sp
                        ComponentSize.LARGE -> 16.sp
                    },
                    onCheckedChange = { isSelected ->
                        checkedOptions[label] = isSelected
                        error = validateSelection(checkedOptions)
                        onCheckedChange(checkedOptions) // Pass updated state to parent
                    },
                    checkedColor = checkedColor,
                    uncheckedColor = uncheckedColor,
                    disabledColor = disabledColor
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        } else {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                checkedOptions.forEach { (label, isChecked) ->
                    CheckboxOption(
                        isChecked = isChecked,
                        label = label,
                        checkSize = when (componentSize) {
                            ComponentSize.SMALL -> 16.dp
                            ComponentSize.MEDIUM -> 20.dp
                            ComponentSize.LARGE -> 24.dp
                        },
                        textFontSize = when (componentSize) {
                            ComponentSize.SMALL -> 12.sp
                            ComponentSize.MEDIUM -> 14.sp
                            ComponentSize.LARGE -> 16.sp
                        },
                        onCheckedChange = { isSelected ->
                            checkedOptions[label] = isSelected
                            error = validateSelection(checkedOptions)
                            onCheckedChange(checkedOptions) // Pass updated state to parent
                        },
                        checkedColor = checkedColor,
                        uncheckedColor = uncheckedColor,
                        disabledColor = disabledColor
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Information Text
        if (informationText.isNotEmpty()) {
            InformationText(
                informationText = informationText,
                informationTextStyle = informationTextStyle,
                informationTextColor = informationTextColor
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        // Error Text
        if (error.isNotEmpty()) {
            ErrorText(
                errorText = error,
                errorTextStyle = errorTextStyle,
                errorTextColor = errorTextColor
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
private fun CheckboxOption(
    modifier: Modifier = Modifier,
    label: String = "",
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    checkSize: Dp,
    textFontSize: TextUnit,
    checkedColor: Color = Color.Blue,
    uncheckedColor: Color = Color.Gray,
    disabledColor: Color = Color.LightGray
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable(
                onClick = { onCheckedChange(!isChecked) },
                indication = null, // Disables the ripple effect
                interactionSource = remember { MutableInteractionSource() }
            )
    ) {
        Checkbox(
            modifier = Modifier.size(checkSize),
            checked = isChecked,
            onCheckedChange = null,
            colors = CheckboxDefaults.colors(
                checkedColor = checkedColor,
                uncheckedColor = uncheckedColor,
                disabledCheckedColor = disabledColor,
                disabledUncheckedColor = disabledColor,
                disabledIndeterminateColor = disabledColor,
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label, fontSize = textFontSize, color = Color.Black)
    }
}

@Composable
fun InformationText(
    informationText: String,
    informationTextStyle: TextStyle,
    informationTextColor: Color
) {
    Text(
        text = informationText,
        style = informationTextStyle,
        color = informationTextColor
    )
}

@Composable
fun ErrorText(
    errorText: String,
    errorTextStyle: TextStyle,
    errorTextColor: Color
) {
    Text(
        text = errorText,
        style = errorTextStyle,
        color = errorTextColor
    )
}

private fun validateSelection(checkedOptions: Map<String, Boolean>): String {
    val selectedCount = checkedOptions.count { it.value }
    return when {
        selectedCount == 0 -> "Please select at least one option."
        selectedCount > 1 -> "Please select only one option."
        else -> ""
    }
}
