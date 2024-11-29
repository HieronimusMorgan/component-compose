import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import co.id.nexsoft.component.button.ButtonComponent
import co.id.nexsoft.component.checkbox.CheckboxComponent
import co.id.nexsoft.component.informationcard.InformationCardComponent
import co.id.nexsoft.component.informationcard.InformationCardType
import co.id.nexsoft.component.textfield.TextFieldComponent
import co.id.nexsoft.component.textfield.TextInputType
import co.id.nexsoft.component.util.theme.BodyMedium
import co.id.nexsoft.component.util.theme.CaptionLarge
import co.id.nexsoft.component.util.theme.ComponentSize
import co.id.nexsoft.component.util.theme.ComponentType

@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel()) {
    val loginState by viewModel.loginState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        InformationCardComponent(
            modifier = Modifier.fillMaxWidth(),
            title = "Important Information",
            titleStyle = CaptionLarge,
            titleFontWeight = FontWeight.Bold,
            description = "Your information is safe, but please double-check your credentials.",
            descriptionStyle = BodyMedium,
            descriptionFontWeight = FontWeight.Normal,
            backgroundColor = Color.Transparent,
            borderColor = Color.Transparent,
            type = InformationCardType.INFO,
            buttonLabel = "Learn More",
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextFieldComponent(
            modifier = Modifier.fillMaxWidth(),
            id = "txt_email",
            labelModifier = Modifier,
            textStyleLabel = BodyMedium,
            label = "Email Address",
            value = loginState.email,
            readOnly = false,
            enable = true,
            hint = "Enter your email",
            onImeAction = ImeAction.Next,
            componentSize = ComponentSize.MEDIUM,
            singleLine = true,
            textInputType = TextInputType.TEXT,
            onTextChanged = { viewModel.onEmailChanged(it) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextFieldComponent(
            modifier = Modifier.fillMaxWidth(),
            id = "txt_password",
            labelModifier = Modifier,
            textStyleLabel = BodyMedium,
            label = "Password",
            value = loginState.password,
            readOnly = false,
            enable = true,
            hint = "Enter your password",
            onImeAction = ImeAction.Done,
            componentSize = ComponentSize.MEDIUM,
            singleLine = true,
            textInputType = TextInputType.PASSWORD,
            onTextChanged = { viewModel.onPasswordChanged(it) }
        )

        Spacer(modifier = Modifier.height(8.dp))
        val options = remember {
            mutableStateMapOf(
                "checked" to loginState.rememberMe
            )
        }

        // Function to handle changes to checkbox states
        val onCheckedChange: (Map<String, Boolean>) -> Unit = { updatedOptions ->
            options.putAll(updatedOptions) // Update the snapshot-backed map
        }
        CheckboxComponent(
            title = "Remember Me",
            options = options,
            componentSize = ComponentSize.MEDIUM,
            onCheckedChange = onCheckedChange
        )

        Spacer(modifier = Modifier.height(8.dp))

        ButtonComponent(
            modifier = Modifier.fillMaxWidth(),
            id = "btn_login",
            label = "Login",
            componentSize = ComponentSize.MEDIUM,
            componentType = ComponentType.PRIMARY,
            componentColor = MaterialTheme.colorScheme.primary,
            underline = false,
            enabled = true,
            onClick = { viewModel.onLogin() }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Forgot Password?",
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            style = LocalTextStyle.current
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
