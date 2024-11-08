package co.id.nexsoft.component.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.id.nexsoft.component.util.theme.BodyLarge
import co.id.nexsoft.component.util.theme.BodyMedium
import co.id.nexsoft.component.util.theme.ComponentSize
import co.id.nexsoft.component.util.theme.setId

@Preview(showBackground = true)
@Composable
fun Preview() {
    Column {
        TextFieldComponent(label = "Password",
            textStyleLabel = BodyLarge,
            value = "",
            componentSize = ComponentSize.LARGE,
            hint = "Enter your password",
            onTextChanged = { /* handle text change */ })
        TextFieldComponent(label = "Password",
            value = "",
            textInputType = TextInputType.PASSWORD,
            hint = "Enter your password",
            onTextChanged = { /* handle text change */ })
        TextFieldComponent(label = "Password",
            value = "",
            hint = "Enter your password",
            prefixIconImages = Pair(Icons.Filled.Favorite, null),
            onClickIcon = { /* handle icon click */ },
            onTextChanged = { /* handle text change */ })
        TextFieldComponent(label = "Phone Number",
            value = "",
            textInputType = TextInputType.PHONE,
            countryCode = "+6",
            countryCodes = listOf("+11", "+22", "+33", "+44", "+55", "+66"),
            onCountryCodeClick = { /* Handle country code selection */ },
            onTextChanged = { /* Handle text input */ })
        TextFieldComponent(
            label = "Select an Option",
            value = "",
            textInputType = TextInputType.DROPDOWN,
            dropdownOptions = listOf("Option 1", "Option 2", "Option 3"),
            onDropdownOptionSelected = {/* Handle country code selection */ },
            hint = "Choose from the list"
        )

        TextFieldComponent(
            modifier = Modifier,
            id = "txt_1",
            labelModifier = Modifier,
            textStyleLabel = BodyMedium,
            label = "Password",
            value = "",
            readOnly = false,
            enable = true,
            hint = "",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.LARGE,
            singleLine = true,
            textInputType = TextInputType.TEXT,
            suffixIconImages = null,
            prefixIconImages = null,
            prefixText = null,
            onClickIcon = { /* handle icon click */ },
            onTextChanged = { /* handle text change */ },
            countryCodes = emptyList(),
            countryCode = "+62",
            onCountryCodeClick = { /* handle country code selection */ },
            dropdownOptions = emptyList(),
            onDropdownOptionSelected = { /* handle dropdown option selection */ },
        )
    }
}

/**
 * Composable function to create a customizable text field component.
 *
 * @param modifier Modifier to be applied to the text field.
 * @param id Optional ID for the text field.
 * @param labelModifier Modifier to be applied to the label.
 * @param textStyleLabel Text style for the label.
 * @param label The label text to be displayed above the text field.
 * @param value The current text value of the text field.
 * @param readOnly Whether the text field is read-only.
 * @param enable Whether the text field is enabled.
 * @param hint Hint text to be displayed when the text field is empty.
 * @param onImeAction IME action to be performed.
 * @param componentSize Size of the text field component.
 * @param singleLine Whether the text field is single-line.
 * @param textInputType Type of text input (e.g., TEXT, PASSWORD, PHONE, DROPDOWN).
 * @param suffixIconImages Optional pair of suffix icons.
 * @param prefixIconImages Optional pair of prefix icons.
 * @param prefixText Optional prefix text to be displayed inside the text field.
 * @param onClickIcon Callback function to be invoked when an icon is clicked.
 * @param onTextChanged Callback function to be invoked when the text changes.
 * @param countryCodes List of country codes for phone number input.
 * @param countryCode Default country code for phone number input.
 * @param onCountryCodeClick Callback function to be invoked when a country code is selected.
 * @param dropdownOptions List of options for dropdown input.
 * @param onDropdownOptionSelected Callback function to be invoked when a dropdown option is selected.
 */
@Composable
fun TextFieldComponent(
    modifier: Modifier = Modifier,
    id: String? = null,
    labelModifier: Modifier = Modifier,
    textStyleLabel: TextStyle = BodyMedium,
    label: String = "",
    value: String = "",
    readOnly: Boolean = false,
    enable: Boolean = true,
    hint: String = "",
    onImeAction: ImeAction = ImeAction.Done,
    componentSize: ComponentSize = ComponentSize.LARGE,
    singleLine: Boolean = true,
    textInputType: TextInputType = TextInputType.TEXT,
    suffixIconImages: Pair<ImageVector?, ImageVector?>? = null,
    prefixIconImages: Pair<ImageVector?, ImageVector?>? = null,
    prefixText: String? = null,
    onClickIcon: (() -> Unit)? = { },
    onTextChanged: (String) -> Unit = {},
    countryCodes: List<String> = emptyList(),
    countryCode: String = "+62",
    onCountryCodeClick: (String) -> Unit = {},
    dropdownOptions: List<String> = emptyList(),
    onDropdownOptionSelected: (String) -> Unit = {}
) {
    modifier.layoutId("txt_${setId(id, label)}")

    var text by remember { mutableStateOf(value) }
    var isFocused by remember { mutableStateOf(false) }
    var passwordVisibility by remember { mutableStateOf(false) }
    val passwordIcon =
        if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

    Column {
        LabelSection(label, labelModifier, textStyleLabel, componentSize)

        when (textInputType) {
            TextInputType.PASSWORD -> {
                TextField(modifier = modifier,
                    text = text,
                    hint = hint,
                    onTextChanged = {
                        text = it
                        onTextChanged(it)
                    },
                    readOnly = readOnly,
                    enable = enable,
                    isFocused = isFocused,
                    componentSize = componentSize,
                    singleLine = singleLine,
                    textInputType = if (passwordVisibility) TextInputType.TEXT else TextInputType.PASSWORD,
                    onImeAction = onImeAction,
                    prefixText = prefixText,
                    prefixIconImages = prefixIconImages,
                    suffixIconImages = Pair(passwordIcon, null),
                    onClickIcon = { passwordVisibility = !passwordVisibility },
                    onFocusChanged = { isFocused = it })
            }

            TextInputType.PHONE -> {
                TextFieldPhoneNumber(modifier = modifier,
                    text = text,
                    hint = hint,
                    isFocused = isFocused,
                    readOnly = readOnly,
                    enable = enable,
                    componentSize = componentSize,
                    singleLine = singleLine,
                    textInputType = textInputType,
                    onImeAction = onImeAction,
                    onFocusChanged = { isFocused = it },
                    countryCode = countryCode,
                    onCountryCodeClick = onCountryCodeClick,
                    countryCodes = countryCodes,
                    onTextChanged = { text = it })
            }

            TextInputType.DROPDOWN -> {
                DropdownTextField(modifier = modifier,
                    text = text,
                    hint = hint,
                    dropdownOptions = dropdownOptions,
                    onDropdownOptionSelected = {
                        text = it
                        onDropdownOptionSelected(it)
                    },
                    isFocused = isFocused,
                    componentSize = componentSize,
                    onFocusChanged = { isFocused = it })
            }

            else -> {
                TextField(modifier = modifier,
                    text = text,
                    hint = hint,
                    onTextChanged = {
                        text = it
                        onTextChanged(it)
                    },
                    isFocused = isFocused,
                    componentSize = componentSize,
                    readOnly = readOnly,
                    enable = enable,
                    singleLine = singleLine,
                    textInputType = textInputType,
                    onImeAction = onImeAction,
                    prefixText = prefixText,
                    prefixIconImages = prefixIconImages,
                    suffixIconImages = suffixIconImages,
                    onClickIcon = onClickIcon,
                    onFocusChanged = { isFocused = it })
            }
        }
    }
}

@Composable
private fun LabelSection(
    label: String,
    modifier: Modifier,
    textStyleLabel: TextStyle,
    componentSize: ComponentSize = ComponentSize.MEDIUM
) {
    if (label.isNotEmpty()) {
        Text(
            modifier = modifier,
            text = label,
            style = textStyleLabel,
            fontSize = fontSizeForComponentSize(componentSize)
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
private fun TextField(
    modifier: Modifier,
    text: String,
    hint: String,
    readOnly: Boolean,
    enable: Boolean,
    onTextChanged: (String) -> Unit,
    isFocused: Boolean,
    componentSize: ComponentSize,
    singleLine: Boolean,
    textInputType: TextInputType,
    onImeAction: ImeAction,
    prefixText: String? = null,
    prefixIconImages: Pair<ImageVector?, ImageVector?>? = null,
    suffixIconImages: Pair<ImageVector?, ImageVector?>? = null,
    onClickIcon: (() -> Unit)? = {},
    onFocusChanged: (Boolean) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Row(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = if (isFocused) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(
                    alpha = 0.5f
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                start = 16.dp, top = when (componentSize) {
                    ComponentSize.SMALL -> 8.dp
                    ComponentSize.MEDIUM -> 10.dp
                    ComponentSize.LARGE -> 12.dp
                }, end = 16.dp, bottom = when (componentSize) {
                    ComponentSize.SMALL -> 8.dp
                    ComponentSize.MEDIUM -> 10.dp
                    ComponentSize.LARGE -> 12.dp
                }
            )
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        PrefixLayout(prefixText, componentSize, prefixIconImages, onClickIcon)

        BasicTextField(
            value = text,
            onValueChange = onTextChanged,
            readOnly = readOnly,
            enabled = enable,
            textStyle = TextStyle.Default.copy(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = fontSizeForComponentSize(componentSize)
            ),
            singleLine = singleLine,
            modifier = modifier
                .weight(1f)
                .onFocusChanged { onFocusChanged(it.isFocused) },
            decorationBox = { innerTextField ->
                if (text.isEmpty()) Text(
                    hint,
                    color = Color.Gray,
                    style = TextStyle(fontSize = fontSizeForComponentSize(componentSize))
                )
                innerTextField()
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = when (textInputType) {
                    TextInputType.PHONE -> KeyboardType.Phone
                    TextInputType.PASSWORD -> KeyboardType.Password
                    else -> KeyboardType.Text
                }, imeAction = onImeAction
            ),
            keyboardActions = KeyboardActions(onAny = {
                keyboardController?.hide()
                focusManager.clearFocus()
            }),
            visualTransformation = if (textInputType == TextInputType.PASSWORD) PasswordVisualTransformation() else VisualTransformation.None
        )

        IconSection(suffixIconImages, onClickIcon, componentSize)
    }
}

@Composable
private fun TextFieldPhoneNumber(
    modifier: Modifier,
    text: String,
    hint: String,
    isFocused: Boolean,
    readOnly: Boolean,
    enable: Boolean,
    componentSize: ComponentSize,
    singleLine: Boolean,
    textInputType: TextInputType,
    onImeAction: ImeAction,
    onFocusChanged: (Boolean) -> Unit,
    countryCode: String = "+62",
    onCountryCodeClick: (String) -> Unit = {},
    countryCodes: List<String> = emptyList(),
    onTextChanged: (String) -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Row(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = if (isFocused) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(
                    alpha = 0.5f
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                start = 16.dp, top = when (componentSize) {
                    ComponentSize.SMALL -> 8.dp
                    ComponentSize.MEDIUM -> 10.dp
                    ComponentSize.LARGE -> 12.dp
                }, end = 16.dp, bottom = when (componentSize) {
                    ComponentSize.SMALL -> 8.dp
                    ComponentSize.MEDIUM -> 10.dp
                    ComponentSize.LARGE -> 12.dp
                }
            )
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        // Prefix Section with Country Code and Dropdown Icon
        if (countryCodes.isNotEmpty()) {
            CountryCodePrefix(countryCode, onCountryCodeClick, countryCodes, componentSize)

            Spacer(modifier = Modifier.width(8.dp))
        }
        // Text Field
        BasicTextField(
            value = text,
            readOnly = readOnly,
            enabled = enable,
            onValueChange = onTextChanged,
            textStyle = TextStyle.Default.copy(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = fontSizeForComponentSize(componentSize)
            ),
            singleLine = singleLine,
            modifier = modifier
                .weight(1f)
                .onFocusChanged { onFocusChanged(it.isFocused) },
            decorationBox = { innerTextField ->
                if (text.isEmpty() && hint.isNotEmpty()) {
                    Text(
                        text = hint, color = Color.Gray, style = TextStyle(
                            fontSize = fontSizeForComponentSize(componentSize)
                        )
                    )
                }
                innerTextField()
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone, imeAction = onImeAction
            ),
            keyboardActions = KeyboardActions(onAny = {
                keyboardController?.hide()
                focusManager.clearFocus()
            }),
            visualTransformation = if (textInputType == TextInputType.PASSWORD) PasswordVisualTransformation() else VisualTransformation.None
        )
    }
}

@Composable
private fun DropdownTextField(
    modifier: Modifier,
    text: String,
    hint: String,
    dropdownOptions: List<String>,
    onDropdownOptionSelected: (String) -> Unit,
    isFocused: Boolean,
    componentSize: ComponentSize,
    onFocusChanged: (Boolean) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier
        .border(
            width = 1.dp,
            color = if (isFocused) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(
                alpha = 0.5f
            ),
            shape = RoundedCornerShape(8.dp)
        )
        .padding(
            start = 16.dp, top = when (componentSize) {
                ComponentSize.SMALL -> 8.dp
                ComponentSize.MEDIUM -> 10.dp
                ComponentSize.LARGE -> 12.dp
            }, end = 16.dp, bottom = when (componentSize) {
                ComponentSize.SMALL -> 8.dp
                ComponentSize.MEDIUM -> 10.dp
                ComponentSize.LARGE -> 12.dp
            }
        )
        .fillMaxWidth()
        .clickable { expanded = !expanded }
        .onFocusChanged { onFocusChanged(it.isFocused) }) {

        BasicTextField(
            value = text,
            readOnly = true,
            onValueChange = { },
            textStyle = TextStyle.Default.copy(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = fontSizeForComponentSize(componentSize)
            ),
            singleLine = true,
            modifier = modifier
                .align(Alignment.CenterStart)
                .onFocusChanged { onFocusChanged(it.isFocused) },
            decorationBox = { innerTextField ->
                if (text.isEmpty() && hint.isNotEmpty()) {
                    Text(
                        text = hint, color = Color.Gray, style = TextStyle(
                            fontSize = fontSizeForComponentSize(componentSize)
                        )
                    )
                }
                innerTextField()
            },
        )

        Icon(
            imageVector = if (expanded) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterEnd)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = !expanded },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
        ) {
            dropdownOptions.forEach { option ->
                DropdownMenuItem(text = {
                    Text(
                        text = option,
                        style = TextStyle(fontSize = fontSizeForComponentSize(componentSize))
                    )
                }, onClick = {
                    onDropdownOptionSelected(option)
                    expanded = false
                })
            }
        }
    }
}

@Composable
fun PrefixLayout(
    prefixText: String?,
    componentSize: ComponentSize,
    prefixIconImages: Pair<ImageVector?, ImageVector?>?,
    onClickIcon: (() -> Unit)?
) {
    PrefixText(prefixText, componentSize)
    IconSection(prefixIconImages, onClickIcon, componentSize)
}


@Composable
private fun PrefixText(
    text: String?, componentSize: ComponentSize, modifier: Modifier = Modifier
) {
    if (text != null) {
        Text(
            text = text, style = TextStyle.Default.copy(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = fontSizeForComponentSize(componentSize)
            ), modifier = modifier
        )
        Spacer(modifier = Modifier.width(8.dp)) // Add space after the prefix text
    }
}

@Composable
fun CountryCodePrefix(
    countryCode: String,
    onCountryCodeClick: (String) -> Unit = {},
    countryCodes: List<String>,
    componentSize: ComponentSize = ComponentSize.MEDIUM
) {
    var expanded by remember { mutableStateOf(false) } // Track dropdown visibility
    var choice by remember { mutableStateOf(countryCode) } // Track dropdown visibility
    Row(
        modifier = Modifier.clickable(onClick = { expanded = true }),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = choice, style = TextStyle(
                fontSize = fontSizeForComponentSize(
                    componentSize = componentSize
                )
            )
        )
        Icon(
            imageVector = Icons.Default.ArrowDropDown, // Dropdown arrow icon
            contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.Black
        )
    }
    // Dropdown menu for country codes
    DropdownMenu(expanded = expanded,
        onDismissRequest = { expanded = false } // Close the dropdown when clicked outside
    ) {
        countryCodes.forEach { countryCode ->
            DropdownMenuItem(text = {
                Text(
                    text = countryCode, style = TextStyle(
                        fontSize = fontSizeForComponentSize(
                            componentSize = componentSize
                        )
                    )
                )
            }, onClick = {
                choice = countryCode
                onCountryCodeClick(choice) // Trigger selection callback
                expanded = false // Close the dropdown
            })
        }
    }
}

@Composable
fun IconSection(
    iconImages: Pair<ImageVector?, ImageVector?>?,
    onClick: (() -> Unit)?,
    componentSize: ComponentSize
) {
    iconImages?.let { (icon1, icon2) ->
        icon1?.let {
            IconButton(
                onClick = { onClick?.invoke() },
                modifier = Modifier.size(iconSizeForComponentSize(componentSize))
            ) {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
        icon2?.let {
            IconButton(
                onClick = { onClick?.invoke() },
                modifier = Modifier.size(iconSizeForComponentSize(componentSize))
            ) {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun fontSizeForComponentSize(componentSize: ComponentSize): TextUnit {
    return when (componentSize) {
        ComponentSize.SMALL -> 12.sp
        ComponentSize.MEDIUM -> 14.sp
        ComponentSize.LARGE -> 16.sp
    }
}

@Composable
fun iconSizeForComponentSize(componentSize: ComponentSize): Dp {
    return when (componentSize) {
        ComponentSize.SMALL -> 12.dp
        ComponentSize.MEDIUM -> 14.dp
        ComponentSize.LARGE -> 16.dp
    }
}

enum class TextInputType {
    TEXT, PASSWORD, PHONE, DROPDOWN
}