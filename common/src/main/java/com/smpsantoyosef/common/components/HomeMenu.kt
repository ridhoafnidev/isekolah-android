package com.smpsantoyosef.common.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.smpsantoyosef.entity.Menu
import com.smpsantoyosef.isekolah.ui.theme.White
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeMenu(
    menu: Menu,
    modifier: Modifier = Modifier,
    selected: Boolean,
    onValueChange: (String) -> Unit,
    onItemClick: (Menu) -> Unit,
) {
    val scaleA = remember { Animatable(initialValue = 1f) }
    val scaleB = remember { Animatable(initialValue = 1f) }
    val clickEnabled = remember { mutableStateOf(true) }

    LaunchedEffect(key1 = selected) {
        if (selected) {
            clickEnabled.value = false
            val animateA = launch {
                scaleA.animateTo(
                    targetValue = 0.5f,
                    animationSpec = tween(
                        durationMillis = 50
                    )
                )
                scaleA.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessHigh
                    )
                )
            }
            val animateB = launch {
                scaleB.animateTo(
                    targetValue = 0.9f,
                    animationSpec = tween(
                        durationMillis = 50
                    )
                )
                scaleB.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessHigh
                    )
                )
            }
            animateA.join()
            animateB.join()
            clickEnabled.value = true
        }
    }

    Card(
        modifier = modifier
            .scale(scaleB.value)
            .background(White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(1.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        onClick = {
            onItemClick(menu)
            onValueChange(menu.title)
        }
    ) {
        Box(contentAlignment = Alignment.Center) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(menu.icon),
                    contentDescription = menu.title,
                    modifier = modifier.scale(scaleA.value)
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
