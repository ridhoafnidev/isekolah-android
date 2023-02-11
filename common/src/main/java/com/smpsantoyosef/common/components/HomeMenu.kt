package com.smpsantoyosef.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.smpsantoyosef.entity.Menu
import com.smpsantoyosef.isekolah.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeMenu(
    menu: Menu,
    modifier: Modifier = Modifier,
    onItemClick: (Menu) -> Unit,
) {
    Card(
        modifier = modifier.background(White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(1.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        onClick = { onItemClick(menu) }
    ) {
        Box(contentAlignment = Alignment.Center) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painterResource(menu.icon), contentDescription = menu.title, modifier = modifier
                    .size(88.dp)
                    .padding(top = 24.dp))
                BaseText(text = menu.title, modifier = modifier.padding(top = 10.dp, bottom = 22.dp))
            }
        }
    }

}

/*@Preview
@Composable
fun HomeMenuPrev() {
    HomeMenu(onItemClick = {}, MenuDatasource.generateMenus())
}*/
