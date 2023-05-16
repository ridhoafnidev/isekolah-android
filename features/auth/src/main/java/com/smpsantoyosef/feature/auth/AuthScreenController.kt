package com.smpsantoyosef.feature.auth

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smpsantoyosef.common.utils.NavRoute
import com.smpsantoyosef.feature.auth.ui.screen.AuthViewModel
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
            val viewModel: AuthViewModel = hiltViewModel()
            LoginScreen(parentNavHostController, viewModel)
        }

        composable(
            route = AuthRouters.REGISTER
        ) {
            RegisterScreen(parentNavHostController)
        }

    }
}