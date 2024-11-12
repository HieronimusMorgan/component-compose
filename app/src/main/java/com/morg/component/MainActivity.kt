package com.morg.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import co.id.nexsoft.component.util.theme.ComponentTheme
import com.morg.component.screen.AvatarScreen
import com.morg.component.screen.ButtonIconScreen
import com.morg.component.screen.ButtonScreen
import com.morg.component.screen.CardScreen
import com.morg.component.screen.CheckboxScreen
import com.morg.component.screen.ExpansionScreen
import com.morg.component.screen.ImageScreen
import com.morg.component.screen.InformationCardScreen
import com.morg.component.screen.OTPVerificationScreen
import com.morg.component.screen.RadioScreen
import com.morg.component.screen.RatingScreen
import com.morg.component.screen.StepScreen
import com.morg.component.screen.StepperScreen
import com.morg.component.screen.TextFieldScreen
import com.morg.component.screen.ToggleScreen
import com.morg.component.screen.VideoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentTheme(darkTheme = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        MainScreen()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var title by remember { mutableStateOf("UI Components") } // Default title

    // Observe the current route
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    // Update title based on current route
    title = when (currentRoute) {
        Screen.HOME.route -> "UI Components" // Default title
        Screen.AVATAR.route -> Screen.AVATAR.label
        Screen.BUTTON.route -> Screen.BUTTON.label
        Screen.BUTTON_ICON.route -> Screen.BUTTON_ICON.label
        Screen.CARD.route -> Screen.CARD.label
        Screen.CHECKBOX.route -> Screen.CHECKBOX.label
        Screen.EXPANSION.route -> Screen.EXPANSION.label
        Screen.IMAGE.route -> Screen.IMAGE.label
        Screen.INFORMATION_CARD.route -> Screen.INFORMATION_CARD.label
        Screen.OTP_VERIFICATION.route -> Screen.OTP_VERIFICATION.label
        Screen.RADIO.route -> Screen.RADIO.label
        Screen.RATING.route -> Screen.RATING.label
        Screen.STEPPER.route -> Screen.STEPPER.label
        Screen.STEP.route -> Screen.STEP.label
        Screen.TEXT_FIELD.route -> Screen.TEXT_FIELD.label
        Screen.TOGGLE.route -> Screen.TOGGLE.label
        Screen.VIDEO.route -> Screen.VIDEO.label
        else -> "UI Components" // Fallback default title
    }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            )
    }, content = {
        NavHost(
            navController = navController,
            startDestination = Screen.HOME.route,
            Modifier.padding(it)
        ) {
            composable(Screen.HOME.route) {
                HomeScreen(navController, onItemClicked = { navName -> title = navName })
            }
            composable(Screen.AVATAR.route) { AvatarScreen(navController) }
            composable(Screen.BUTTON.route) { ButtonScreen(navController) }
            composable(Screen.BUTTON_ICON.route) { ButtonIconScreen(navController) }
            composable(Screen.CARD.route) { CardScreen(navController) }
            composable(Screen.CHECKBOX.route) { CheckboxScreen(navController) }
            composable(Screen.EXPANSION.route) { ExpansionScreen(navController) }
            composable(Screen.IMAGE.route) { ImageScreen(navController) }
            composable(Screen.INFORMATION_CARD.route) { InformationCardScreen(navController) }
            composable(Screen.OTP_VERIFICATION.route) { OTPVerificationScreen(navController) }
            composable(Screen.RADIO.route) { RadioScreen(navController) }
            composable(Screen.RATING.route) { RatingScreen(navController) }
            composable(Screen.STEPPER.route) { StepperScreen(navController) }
            composable(Screen.STEP.route) { StepScreen(navController) }
            composable(Screen.TEXT_FIELD.route) { TextFieldScreen(navController) }
            composable(Screen.TOGGLE.route) { ToggleScreen(navController) }
            composable(Screen.VIDEO.route) { VideoScreen(navController) }
        }
    })
}