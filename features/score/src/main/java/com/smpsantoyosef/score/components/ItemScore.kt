package com.smpsantoyosef.score.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.smpsantoyosef.common.components.BaseText
import com.smpsantoyosef.common.components.FontType
import com.smpsantoyosef.entity.Menu
import com.smpsantoyosef.entity.Score
import com.smpsantoyosef.isekolah.ui.theme.Primary
import com.smpsantoyosef.score.R

@Composable
fun <T> ItemScore(
    data: T,
    modifier: Modifier = Modifier,
    onItemClick: (Menu) -> Unit = {},
) {
    val score = data as Score
    Card(
        backgroundColor = Primary,
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onItemClick },
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            BaseText(
                text = stringResource(R.string.mata_pelajaran),
                modifier = modifier.fillMaxWidth(),
                fontColor = Color.White,
                fontFamily = FontType.LIGHT,
            )
            BaseText(
                text = score.course,
                modifier = modifier
                    .padding(top = 8.dp, bottom = 16.dp)
                    .fillMaxWidth(),
                fontColor = Color.White,
                fontFamily = FontType.MEDIUM,
            )
        }
    }
}
