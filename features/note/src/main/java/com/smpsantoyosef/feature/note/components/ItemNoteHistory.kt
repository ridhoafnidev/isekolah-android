package com.smpsantoyosef.feature.note.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smpsantoyosef.common.components.BaseText
import com.smpsantoyosef.common.components.FontType
import com.smpsantoyosef.entity.Menu
import com.smpsantoyosef.entity.Note
import com.smpsantoyosef.feature.note.R
import com.smpsantoyosef.isekolah.ui.theme.Divider
import com.smpsantoyosef.isekolah.ui.theme.Neutral100
import com.smpsantoyosef.isekolah.ui.theme.Neutral300

@Composable
fun <T>ItemNoteHistory(
    data: T,
    modifier: Modifier = Modifier,
    onItemClick: (Menu) -> Unit = {},
) {
    val note = data as Note
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Neutral100, shape = RoundedCornerShape(8.dp))
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable { onItemClick },
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            BaseText(
                text = stringResource(R.string.day_date),
                fontColor = Neutral300,
                fontSize = 12.sp,
                modifier = modifier.fillMaxWidth()
            )
            BaseText(
                text = "${note.day}, ${note.date}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = modifier
                    .padding(top = 8.dp, bottom = 16.dp)
                    .fillMaxWidth(),
            )
            Divider(modifier = modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = Divider)
            )
            BaseText(
                text = stringResource(R.string.note_type),
                fontColor = Neutral300,
                fontSize = 12.sp,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
            BaseText(
                text = note.note,
                fontFamily = FontType.SEMI_BOLD,
                fontSize = 20.sp,
                modifier = modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
            )
        }

    }
}

@Preview
@Composable
fun ItemNoteHistoryPreview() {
    //ItemNoteHistory()
}