package com.smpsantoyosef.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smpsantoyosef.common.R
import com.smpsantoyosef.common.ui.theme.fontMedium
import com.smpsantoyosef.isekolah.ui.theme.Primary

@Composable
fun AppBar(title: String) {
    TopAppBar(
        title = {
            Text(text = title, color = Color.Black)
        },
        backgroundColor = Color.White
    )
}

@Composable
fun AppBar(
    title: String,
    onClickBack:()->Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(
            text = title,
            color = Color.Black,
            fontFamily = fontMedium,
            fontSize = 24.sp )},
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.img_desc_icon_back),
                modifier = modifier.clickable {
                    onClickBack()
                }.padding(start=16.dp)
            )
        },
        backgroundColor = Color.White
    )
}

@Preview
@Composable
fun AppBarPreview() {
    AppBar("Title", onClickBack = {})
}

@Preview
@Composable
fun AppBarTitlePreview() {
    AppBar("Title")
}