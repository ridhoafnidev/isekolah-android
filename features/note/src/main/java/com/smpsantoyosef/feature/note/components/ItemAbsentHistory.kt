package com.smpsantoyosef.feature.note.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smpsantoyosef.common.components.BaseText
import com.smpsantoyosef.common.components.FontType
import com.smpsantoyosef.entity.Menu
import com.smpsantoyosef.entity.Absent
import com.smpsantoyosef.isekolah.ui.theme.Neutral100
import com.smpsantoyosef.isekolah.ui.theme.Neutral300
import com.smpsantoyosef.isekolah.ui.theme.Primary
import com.smpsantoyosef.isekolah.ui.theme.White

@Composable
fun <T>ItemAbsentHistory(
    data: T,
    modifier: Modifier = Modifier,
    onItemClick: (Menu) -> Unit = {},
) {
    val absent = data as Absent
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Neutral100, shape = RoundedCornerShape(8.dp))
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable { onItemClick },
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
        ) {
            Column(
                modifier = modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                BaseText(
                    text = absent.day,
                    fontColor = Neutral300
                )
                BaseText(
                    text = absent.date,
                    fontFamily = FontType.MEDIUM,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = modifier.padding(top = 8.dp)
                )
            }
            Box(
                modifier = modifier
                    .background(color = Primary, shape = RoundedCornerShape(8.dp)),

            ) {
                BaseText(text= absent.status.uppercase(), fontColor = White, modifier = modifier.padding(horizontal = 12.dp, vertical = 2.dp))
            }
        }

        /*BaseButton(
            text = absent.status.uppercase(),
            color = Primary,
            textColor = White,
            sizeCorner = 8.dp,
            contentPaddingVer = 0.dp,
            contentPaddingHor = 12.dp,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 12.dp, end = 16.dp)
                .clickable(enabled = true) {}) {}*/

    }
}

@Preview
@Composable
fun ItemAbsentHistoryPreview() {
    Surface() {
        ItemAbsentHistory(data = Absent(day = "Senin", date = "01-Januari-2023", "Hadir"))
    }
}