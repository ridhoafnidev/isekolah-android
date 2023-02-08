package com.smpsantoyosef.common.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.smpsantoyosef.common.ui.theme.fontLight
import com.smpsantoyosef.isekolah.ui.theme.Neutra400

@Composable
fun BaseText(
    modifier: Modifier = Modifier,
    text: String="",
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = fontLight,
        fontSize = 14.sp,
        color = Neutra400
    )
}