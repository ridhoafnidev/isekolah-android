package com.smpsantoyosef.isekolah.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smpsantoyosef.common.utils.NavRoute
import com.smpsantoyosef.feature.absent.AbsentScreen
import com.smpsantoyosef.feature.auth.MainViewModel
import com.smpsantoyosef.feature.auth.ui.screen.AuthViewModel
import com.smpsantoyosef.feature.auth.ui.screen.login.LoginScreen
import com.smpsantoyosef.feature.auth.ui.screen.register.RegisterScreen
import com.smpsantoyosef.feature.exam.ListExamPage
import com.smpsantoyosef.feature.exam.TestPage
import com.smpsantoyosef.feature.exam.TokenPage
import com.smpsantoyosef.feature.note.NoteScreen
import com.smpsantoyosef.home.HomeScreen
import com.smpsantoyosef.score.components.ScoreScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController();
    val mainViewModel: MainViewModel = hiltViewModel()
    val isLoggedIn by mainViewModel.isLoggedIn.collectAsState()

    LaunchedEffect(Unit) {
        mainViewModel.getIsLoggedInUser()
    }

    isLoggedIn?.let { _isLoggedIn ->
        NavHost(navController = navController, startDestination = if (_isLoggedIn) NavRoute.homeScreen else NavRoute.loginScreen) {
            composable(NavRoute.loginScreen){
                val viewModel: AuthViewModel = hiltViewModel()
                LoginScreen(navController, viewModel)
            }
            composable(NavRoute.registerScreen){
                RegisterScreen(navController)
            }
            composable(NavRoute.homeScreen){
                HomeScreen(navController)
            }
            composable(NavRoute.absentScreen){
                AbsentScreen(navController)
            }
            composable(NavRoute.noteScreen){
                NoteScreen(navController)
            }
            composable(NavRoute.scoreScreen){
                ScoreScreen(navController)
            }
            composable(NavRoute.listExamScreen){
                ListExamPage(navController)
            }
//        composable(NavRoute.detailExamScreen){
//            DetailExamPage(navController)
//        }
            composable(NavRoute.tokeExamScreen){
                TokenPage(navController)
            }
            composable(NavRoute.testExamScreen){
                TestPage(navController)
            }
        }
    }
}