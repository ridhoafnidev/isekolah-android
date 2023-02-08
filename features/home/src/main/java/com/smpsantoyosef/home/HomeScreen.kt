package com.smpsantoyosef.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.smpsantoyosef.home.components.HomeProfile
import com.smpsantoyosef.home.components.VisiMisi

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        HomeProfile(modifier = Modifier.padding(top = 16.dp))
        VisiMisi(modifier = Modifier.padding(top = 24.dp))
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview() {
    val navHostController = rememberNavController()
    HomeScreen(navHostController)
}