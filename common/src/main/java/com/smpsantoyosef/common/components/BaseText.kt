package com.smpsantoyosef.common.components

import androidx.compose.material3.MaterialTheme
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
import com.smpsantoyosef.common.ui.theme.fontSemiBold
import com.smpsantoyosef.isekolah.ui.theme.Neutral900

@Composable
fun BaseText(
    modifier: Modifier = Modifier,
    text: String = "",
    fontFamily: FontType = FontType.REGULAR,
    fontSize: TextUnit = 14.sp,
    fontColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
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
            FontType.SEMI_BOLD -> fontSemiBold
            else -> fontRegular
        }
    )
}

enum class FontType {
    LIGHT, REGULAR, MEDIUM, SEMI_BOLD
}