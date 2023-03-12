package com.smpsantoyosef.feature.exam

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.smpsantoyosef.common.components.BaseAppBar
import com.smpsantoyosef.common.components.BaseButton
import com.smpsantoyosef.common.components.BaseText
import com.smpsantoyosef.common.components.BaseTextField
import com.smpsantoyosef.common.components.FontType
import com.smpsantoyosef.common.utils.NavRoute
import com.smpsantoyosef.isekolah.ui.theme.ISekolahTheme

@Composable
fun TokenPage(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            BaseAppBar(
                title = "Mata Pelajaran".uppercase(),
                subTitle = "Ilmu Pengetahuan Alam",
                onClickBack = {navController.popBackStack()},
                elevation = 1.dp){}
        },
    ) { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding)
        ) {
            TokenExam(navController)
        }
    }
}

@Composable
fun TokenExam(navController: NavHostController) {
    var token by rememberSaveable { mutableStateOf("") }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 16.dp)
    ) {
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 20.dp, bottom = 16.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .padding(horizontal = 16.dp)
            ) {
                BaseText(
                    text = "Masukkan Token terlebih dahulu untuk lanjut ke halaman ujian.",
                    fontFamily = FontType.MEDIUM,
                    fontSize = 16.sp,
                    fontColor = Color.Black
                )
                Spacer(modifier = Modifier.padding(top= 20.dp))
                BaseTextField(
                    value = token,
                    placeholder = "Masukan Token",
                    onValueChange = {token=it},
                    keyboardType = KeyboardType.Password,
                )
            }
        }
        BaseButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(56.dp)
                .fillMaxWidth()
            ,
            text = "Lanjut",
        )
        {
            navController.navigate(NavRoute.testExamScreen)
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light")
@Composable
fun TokenPagePreview() {
    val navHostController = rememberNavController()
    ISekolahTheme() {
        TokenPage(navHostController)
    }
}