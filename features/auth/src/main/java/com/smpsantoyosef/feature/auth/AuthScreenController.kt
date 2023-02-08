package com.smpsantoyosef.feature.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smpsantoyosef.common.utils.NavRoute
import com.smpsantoyosef.feature.auth.ui.screen.login.LoginScreen
import com.smpsantoyosef.feature.auth.ui.screen.register.RegisterScreen

@Composable
fun AuthScreenController(
    parentNavHostController: NavHostController,
    authNavHostController: NavHostController
) {

    NavHost(
        navController = authNavHostController,
        startDestination = AuthRouters.LOGIN
    ) {

        composable(
            route = AuthRouters.LOGIN
        ) {
            LoginScreen(parentNavHostController)
        }

        composable(
            route = AuthRouters.REGISTER
        ) {
            RegisterScreen(parentNavHostController)
        }

    }
}