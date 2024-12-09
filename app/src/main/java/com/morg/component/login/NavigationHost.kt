package com.morg.component.login

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.morg.component.login.screen.LoginScreen

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "login") {
        composable(route = "login") {
            LoginScreen(navController = navController)
        }
//        composable(
//            route = "dashboard/{userId}",
//            arguments = listOf(navArgument("userId") { type = NavType.IntType })
//        ) { backStackEntry ->
//            val userId = backStackEntry.arguments?.getInt("userId")
//            DashboardScreen(navController, userId)
//        }
//        composable(route = "forgot_password") {
//            ForgotPasswordScreen(navController)
//        }
    }
}