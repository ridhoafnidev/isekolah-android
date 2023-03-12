package com.smpsantoyosef.common.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smpsantoyosef.common.ui.theme.fontMedium
import com.smpsantoyosef.isekolah.ui.theme.Primary
import com.smpsantoyosef.isekolah.ui.theme.White

@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Primary,
    textColor: Color = White,
    sizeCorner: Dp = 16.dp,
    contentPaddingVer: Dp = 8.dp,
    contentPaddingHor: Dp = 16.dp,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(sizeCorner),
        contentPadding = PaddingValues(vertical = contentPaddingVer, horizontal = contentPaddingHor),
    ) {
        Text(
            text = text,
            fontFamily = fontMedium,
            fontSize = 16.sp,
            color = textColor,
        )
    }
}

@Preview
@Composable
fun BaseButtonPreview() {
    BaseButton(text = "Button", onClick={})
}