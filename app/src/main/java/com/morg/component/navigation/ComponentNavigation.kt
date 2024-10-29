package com.morg.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.morg.component.screen.AvatarComponent
import com.morg.component.screen.ButtonComponent
import com.morg.component.screen.TextFieldComponent

@Composable
fun ComponentNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ComponentScreen.LIST.name) {
        composable(ComponentScreen.AVATAR.name) {
            AvatarComponent(navController)
        }
        composable(ComponentScreen.TEXT_FIELD.name) {
            TextFieldComponent(navController)
        }
        composable(ComponentScreen.BUTTON.name) {
            ButtonComponent(navController)
        }
    }
}