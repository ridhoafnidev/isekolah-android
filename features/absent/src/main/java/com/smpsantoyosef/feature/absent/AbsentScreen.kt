package com.smpsantoyosef.feature.absent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.smpsantoyosef.common.components.BaseAppBar
import com.smpsantoyosef.common.components.BaseText
import com.smpsantoyosef.common.components.FontType
import com.smpsantoyosef.common.R as commonR
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.smpsantoyosef.feature.absent.components.AbsentMaps

import com.smpsantoyosef.feature.absent.components.AbsentRadioButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AbsentScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            BaseAppBar(
                title = stringResource(R.string.absent),
                onClickBack = { navController.popBackStack() },
                menuIconResource = com.smpsantoyosef.common.R.drawable.ic_history,
                elevation = 1.dp){}
        }
    ){ contentPadding ->
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(contentPadding)
        ) {

            Card(modifier = Modifier
                .fillMaxWidth()
                .height(198.dp))
            {
                AbsentMaps()
            }

            Row(
                modifier = Modifier.padding(top = 16.dp)
            ) {
               Image(
                   painter = painterResource(id = commonR.drawable.ic_map_pin),
                   contentDescription = stringResource(R.string.image_pin_location),
                   modifier = Modifier
                       .size(24.dp)
                       .padding(end = 8.dp)
               )
                BaseText(
                    text = "Jl. Ampera Raya No.7, RT.4/RW.4, Cilandak Tim., Ps. Minggu, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12560",
                    fontFamily = FontType.LIGHT
                )
            }

            Row(modifier = Modifier.padding(top = 48.dp)) {
                BaseText(
                    text = stringResource(R.string.absen),
                    fontSize = 16.sp,
                    fontFamily = FontType.LIGHT,
                    modifier = Modifier.padding(end = 6.dp)
                )
                BaseText(text = stringResource(R.string.required), fontSize = 16.sp, fontFamily = FontType.LIGHT, fontColor = Color.Red)
            }

            AbsentRadioButton(items = listOf("Hadir", "Sakit", "Izin"))
        }
    }
}

@Preview
@Composable
fun AbsentScreenPreview() {
    val navController = rememberNavController()
    AbsentScreen(navController)
}