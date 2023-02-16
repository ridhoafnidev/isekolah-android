package com.smpsantoyosef.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smpsantoyosef.common.ui.theme.fontMedium
import com.smpsantoyosef.common.ui.theme.fontRegular
import com.smpsantoyosef.home.R
import com.smpsantoyosef.isekolah.ui.theme.Neutral300
import com.smpsantoyosef.isekolah.ui.theme.Neutral900
import com.smpsantoyosef.common.R as commonR

@Composable
fun HomeProfile(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        /*AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://fastly.picsum.photos/id/377/200/300.jpg?hmac=veEWg3ApI7rkKqMF6MuaWBmxPgnEe-Ar9eDdMG3q-kk")
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.image_profile),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )*/
        Image(painter = painterResource(commonR.drawable.avatar),
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(11.dp))
        Column {
            Text(
                text = stringResource(R.string.welcome),
                fontFamily = fontRegular,
                color = Neutral300,
                fontSize = 14.sp
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, end = 8.dp),
                text = stringResource(R.string.welcome),
                fontFamily = fontMedium,
                color = Neutral900,
                fontSize = 20.sp
            )
        }
    }
}

@Preview
@Composable
fun HomeProfilePreview() {
    HomeProfile()
}