package com.smpsantoyosef.common.components.tablayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TabContentScreen(
    tabType: TabType,
    pager: Int,
    contentOne: @Composable () -> Unit,
    contentTwo: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        when {
            (tabType == TabType.HISTORY || tabType == TabType.SCORE) && pager == 0 -> {
                contentOne()
            }
            (tabType == TabType.HISTORY || tabType == TabType.SCORE) && pager == 1 -> {
                contentTwo()
            }
        }
    }
}