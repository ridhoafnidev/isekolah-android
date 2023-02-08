package com.smpsantoyosef.feature.auth.ui.screen.login

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.smpsantoyosef.common.components.BaseButton
import com.smpsantoyosef.common.components.BaseTextField
import com.smpsantoyosef.common.ui.theme.fontRegular
import com.smpsantoyosef.common.utils.NavRoute
import com.smpsantoyosef.feature.auth.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navHostController: NavHostController,
) {

    var nisn by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        ){ contentPadding ->
        Box(modifier = Modifier.fillMaxSize()){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .background(Color.White),
                verticalArrangement =Arrangement.Center
            ) {
                BaseTextField(
                    modifier = Modifier.padding(contentPadding),
                    value = nisn,
                    title = stringResource(R.string.nisn),
                    keyboardType = KeyboardType.Number,
                    onValueChange = {nisn = it},
                    placeholder = stringResource(R.string.hint_nisn)
                )
                BaseTextField(
                    modifier = Modifier
                        .padding(contentPadding)
                        .padding(top = 16.dp),
                    value = password,
                    title = stringResource(R.string.password),
                    keyboardType = KeyboardType.Password,
                    onValueChange = {password = it},
                    placeholder = stringResource(R.string.hint_password)
                )
                BaseButton(
                    modifier = Modifier
                        .padding(contentPadding)
                        .padding(top = 64.dp)
                        .height(56.dp)
                        .fillMaxWidth(),
                    text = stringResource(R.string.login))
                {
                    navHostController.navigate(NavRoute.homeScreen)
                }
            }
            Text(
                modifier = Modifier.align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp)
                    .padding(horizontal = 72.dp),
                textAlign = TextAlign.Center,
                text = stringResource(R.string.address),
                fontFamily = fontRegular,
                fontSize = 10.sp,
            )
        }

    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController();
    LoginScreen(navController)
}
