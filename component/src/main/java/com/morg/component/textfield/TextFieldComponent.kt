package com.morg.component.textfield

import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import com.morg.component.ui.theme.BodyMediumMedium
import com.morg.component.ui.theme.ComponentSize

@Preview(showBackground = true)
@Composable
fun Preview() {
    Column {
        TextFieldComponent(label = "Password",
            value = "",
            hint = "Enter your password",
            onTextChanged = { /* handle text change */ })
        TextFieldComponent(label = "Password",
            value = "",
            textInputType = TextInputType.PASSWORD,
            hint = "Enter your password",
            onTextChanged = { /* handle text change */ })
    }
}

@Composable
fun TextFieldComponent(
    modifier: Modifier = Modifier,
    labelModifier: Modifier = Modifier,
    textStyleLabel: TextStyle = BodyMediumMedium,
    label: String = "",
    value: String = "",
    hint: String = "Enter text here",
    onImeAction: ImeAction = ImeAction.Done,
    componentSize: ComponentSize = ComponentSize.LARGE,
    singleLine: Boolean = true,
    textInputType: TextInputType = TextInputType.NORMAL,
    suffixIconImages: Pair<ImageVector?, ImageVector?>? = null,
    prefixIconImages: Pair<ImageVector?, ImageVector?>? = null,
    prefixText: String? = null,
    onClickIcon: (() -> Unit)? = { },
    onTextChanged: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf(value) }
    var isFocused by remember { mutableStateOf(false) }
    Column {
        if (textInputType == TextInputType.PASSWORD) {
            var passwordVisibility by remember { mutableStateOf(false) }
            var password by remember { mutableStateOf(value) }
            LabelSection(label, labelModifier, textStyleLabel)
            TextField(modifier = modifier,
                text = password,
                hint = hint,
                onTextChanged = {
                    password = it
                    onTextChanged(it)
                },
                isFocused = isFocused,
                componentSize = componentSize,
                singleLine = singleLine,
                textInputType = if (passwordVisibility) TextInputType.NORMAL else TextInputType.PASSWORD,
                onImeAction = onImeAction,
                prefixText = prefixText,
                prefixIconImages = prefixIconImages,
                suffixIconImages = Pair(
                    if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    null
                ), // Toggle password visibility icon
                onClickIcon = { passwordVisibility = !passwordVisibility },
                onFocusChanged = { isFocused = it })
        } else {

            LabelSection(label, labelModifier, textStyleLabel)
            TextField(modifier = modifier,
                text = text,
                hint = hint,
                onTextChanged = {
                    text = it
                    onTextChanged(it)
                },
                isFocused = isFocused,
                componentSize = componentSize,
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

@Composable
private fun LabelSection(
    label: String, modifier: Modifier, textStyleLabel: TextStyle
) {
    if (label.isNotEmpty()) {
        Text(
            modifier = modifier, text = label, style = textStyleLabel
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
}


@Composable
private fun TextField(
    modifier: Modifier,
    text: String,
    hint: String,
    onTextChanged: (String) -> Unit,
    isFocused: Boolean,
    componentSize: ComponentSize,
    singleLine: Boolean,
    textInputType: TextInputType,
    onImeAction: ImeAction,
    prefixText: String? = null,
    prefixIconImages: Pair<ImageVector?, ImageVector?>?,
    suffixIconImages: Pair<ImageVector?, ImageVector?>?,
    onClickIcon: (() -> Unit)?,
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
        // Prefix Icons
        PrefixLayout(
            prefixText = prefixText,
            componentSize = componentSize,
            prefixIconImages = prefixIconImages,
            onClickIcon = onClickIcon
        )

        // Text Field
        BasicTextField(
            value = text,
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
                keyboardType = when (textInputType) {
                    TextInputType.PHONE -> KeyboardType.Phone
                    TextInputType.SEARCH, TextInputType.NORMAL -> KeyboardType.Text
                    TextInputType.PASSWORD -> KeyboardType.Password
                }, imeAction = onImeAction
            ),
            keyboardActions = KeyboardActions(onAny = {
                keyboardController?.hide()
                focusManager.clearFocus()
            }),
            visualTransformation = if (textInputType == TextInputType.PASSWORD) PasswordVisualTransformation() else VisualTransformation.None
        )

        // Suffix Icons
        IconSection(suffixIconImages, onClickIcon, componentSize)
    }
}

@Composable
fun PrefixLayout(
    prefixText: String?,
    componentSize: ComponentSize,
    prefixIconImages: Pair<ImageVector?, ImageVector?>?,
    onClickIcon: (() -> Unit)?
) {
    PrefixText(text = prefixText, componentSize = componentSize)
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
private fun IconSection(
    iconImages: Pair<ImageVector?, ImageVector?>?,
    onClick: (() -> Unit)?,
    componentSize: ComponentSize // Add this parameter for dynamic icon sizing
) {
    if (iconImages != null) {
        val (icon1, icon2) = iconImages
        val iconSize = iconSizeForComponentSize(componentSize) // Use the icon size function

        icon1?.let {
            IconButton(onClick = { onClick?.invoke() }, modifier = Modifier.size(iconSize)) {
                Icon(
                    imageVector = it, contentDescription = null, // Set dynamic icon size
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        icon2?.let {
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { onClick?.invoke() }, modifier = Modifier.size(iconSize)) {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    modifier = Modifier.size(iconSize), // Set dynamic icon size
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}


@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    label: String = "Password ",
    componentSize: ComponentSize = ComponentSize.SMALL,
    hint: String = "Enter your password",
    onPasswordChange: (String) -> Unit = {}
) {
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    val textSize = (when (componentSize) {
        ComponentSize.SMALL -> 12.sp
        ComponentSize.MEDIUM -> 14.sp
        ComponentSize.LARGE -> 16.sp
    })
    Column {
        // Label
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // OutlinedTextField
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                onPasswordChange(it)
            },
            placeholder = {
                if (hint.isNotEmpty()) Text(
                    text = hint, style = TextStyle(fontSize = textSize)
                )
            },
            singleLine = true,
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            shape = RoundedCornerShape(8.dp),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Toggle Password Visibility",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            textStyle = TextStyle(fontSize = fontSizeForComponentSize(componentSize)),
            modifier = modifier,

            )
    }
}

//@Preview(showBackground = true)
@Composable
fun PasswordOutlinedTextFieldPreview() {
    Surface {
        PasswordTextField()
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
    NORMAL, PASSWORD, PHONE, SEARCH
}