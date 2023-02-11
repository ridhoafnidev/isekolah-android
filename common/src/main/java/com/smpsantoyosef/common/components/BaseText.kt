package com.smpsantoyosef.common.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.smpsantoyosef.common.ui.theme.fontLight
import com.smpsantoyosef.common.ui.theme.fontMedium
import com.smpsantoyosef.common.ui.theme.fontRegular
import com.smpsantoyosef.isekolah.ui.theme.Neutra900

@Composable
fun BaseText(
    modifier: Modifier = Modifier,
    text: String = "",
    fontFamily: FontType = FontType.REGULAR,
    fontSize: TextUnit = 14.sp,
    fontColor: Color = Neutra900,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        color = fontColor,
        fontWeight = fontWeight,
        fontFamily = when(fontFamily) {
            FontType.MEDIUM -> fontMedium
            FontType.LIGHT -> fontLight
            else -> fontRegular
        }
    )
}

enum class FontType {
    LIGHT, REGULAR, MEDIUM
}