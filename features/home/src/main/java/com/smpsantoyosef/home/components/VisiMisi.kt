package com.smpsantoyosef.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smpsantoyosef.common.R
import com.smpsantoyosef.common.components.BaseButton
import com.smpsantoyosef.common.ui.theme.fontMedium
import com.smpsantoyosef.common.ui.theme.fontRegular
import com.smpsantoyosef.isekolah.ui.theme.Primary
import com.smpsantoyosef.isekolah.ui.theme.Primary50
import com.smpsantoyosef.isekolah.ui.theme.White

@Composable
fun VisiMisi(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            modifier = modifier
                .height(240.dp)
                .clip(RoundedCornerShape(16.dp))
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            Brush.horizontalGradient(
                                0.5f to Primary.copy(alpha = 0.9F),
                                10F to Color.Transparent,
                            )
                        )
                    }
                },
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner",
            contentScale = ContentScale.Crop,
        )
        Column(modifier = modifier.padding(20.dp)) {
            Text(text = "Visi & Misi", fontSize = 32.sp, color = White, fontFamily = fontMedium, fontWeight = FontWeight.Bold)
            Text(text = "“Berakhlak Mulia, Berprestasi, \nBerbasis Lingkungan”", fontSize = 14.sp, color = White, fontFamily = fontRegular, modifier = Modifier.padding(top = 12.dp))
            BaseButton(text = "Selengkapnya", color = Primary50, textColor = Primary, sizeCorner = 8.dp, modifier = Modifier.padding(top = 20.dp), contentPaddingVer=2.dp) {
            }
        }
    }
}

@Preview
@Composable
fun VisiMisiPreview() {
    VisiMisi()
}