package com.smpsantoyosef.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smpsantoyosef.common.R

@Composable
fun BaseAppBar(
    title: String,
    onClickBack:()->Unit,
    modifier: Modifier = Modifier,
    @DrawableRes menuIconResource: Int? = null,
    elevation: Dp = 2.dp,
    onMenuClick: () -> Unit,
) {
    TopAppBar(
        title = {
            BaseText(
                text = title,
                fontFamily = FontType.MEDIUM,
                fontSize = 24.sp
            )
        },
        elevation = elevation,
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.img_desc_icon_back),
                modifier = modifier
                    .clickable {
                        onClickBack()
                    }
                    .padding(16.dp),
                tint = Color.Black
            )
        },
        actions = {
            if (menuIconResource != null) IconButton(onClick = { onMenuClick() }) {
                Icon(
                    painter = painterResource(id = menuIconResource),
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        },
        backgroundColor = Color.White
    )
}

@Preview
@Composable
fun AppBarPreview() {
    BaseAppBar("Title", onClickBack = {}, onMenuClick = {})
}
