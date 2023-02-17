package com.smpsantoyosef.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.smpsantoyosef.common.components.BaseText
import com.smpsantoyosef.common.components.FontType
import com.smpsantoyosef.common.components.HomeMenu
import com.smpsantoyosef.common.utils.NavRoute
import com.smpsantoyosef.data.utils.DummyDatasource
import com.smpsantoyosef.home.components.HomeProfile
import com.smpsantoyosef.home.components.VisiMisi

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ){
        HomeProfile(modifier = Modifier.padding(top = 16.dp))
        VisiMisi(modifier = Modifier.padding(top = 24.dp))
        BaseText(
            text = stringResource(R.string.all_menu),
            fontFamily = FontType.MEDIUM,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 40.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(8.dp),
            content = {
                items(DummyDatasource.generateMenus()) { menu ->
                    HomeMenu(
                        menu = menu,
                        onItemClick = { menu ->
                            when(menu.title) {
                                "Absensi" -> navController.navigate(NavRoute.absentScreen)
                                "Catatan" -> navController.navigate(NavRoute.noteScreen)
                                "Nilai" -> {}
                                "Ujian" -> {}
                            }
                        }
                    )
                }
            }
        )
    }
}
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview() {
    val navHostController = rememberNavController()
    Surface() {
        HomeScreen(navHostController)
    }
}