package com.smpsantoyosef.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.smpsantoyosef.isekolah.ui.theme.Primary

@Composable
fun Loading(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            modifier = modifier
                .size(48.dp),
            strokeWidth =4.dp,
            color = Primary
        )
    }
}

@Preview
@Composable
fun previewLoading() {
    Loading()
}