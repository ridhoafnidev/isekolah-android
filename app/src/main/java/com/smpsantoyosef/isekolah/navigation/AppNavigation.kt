package com.smpsantoyosef.isekolah.navigation

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smpsantoyosef.common.utils.NavRoute
import com.smpsantoyosef.feature.auth.ui.screen.login.LoginScreen
import com.smpsantoyosef.feature.auth.ui.screen.register.RegisterScreen
import com.smpsantoyosef.home.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController();
    NavHost(navController = navController, startDestination = NavRoute.loginScreen) {
        composable(NavRoute.loginScreen){
            LoginScreen(navController)
        }
        composable(NavRoute.registerScreen){
            RegisterScreen(navController)
        }
        composable(NavRoute.homeScreen){
            HomeScreen(navController)
        }
        composable(NavRoute.absentScreen){
            RegisterScreen(navController)
        }
        composable(NavRoute.noteScreen){
            RegisterScreen(navController)
        }
        composable(NavRoute.scoreScreen){
            RegisterScreen(navController)
        }
        composable(NavRoute.examScreen){
            RegisterScreen(navController)
        }
    }
}