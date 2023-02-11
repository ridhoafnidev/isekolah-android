package com.smpsantoyosef.feature.note

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.smpsantoyosef.common.components.BaseAppBar
import com.smpsantoyosef.common.components.tablayout.TabLayout
import com.smpsantoyosef.common.components.tablayout.TabType
import com.smpsantoyosef.data.utils.DummyDatasource
import com.smpsantoyosef.feature.note.components.page.TabAbsentScreen
import com.smpsantoyosef.feature.note.components.page.TabNoteScreen
import com.smpsantoyosef.common.R as commonR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    navController: NavHostController
) {
    val menus = listOf(
        stringResource(R.string.absent),
        stringResource(R.string.note)
    )

    Scaffold(
        topBar = {
            BaseAppBar(
                title = stringResource(R.string.riwayat),
                onClickBack = {navController.popBackStack()},
                menuIconResource = commonR.drawable.ic_filter,
                elevation = 1.dp){}
        }
    ){ contentPadding ->
        TabLayout(
            modifier = Modifier.padding(contentPadding),
            menus = menus,
            tabType = TabType.HISTORY,
            contentOne = {
                TabAbsentScreen(DummyDatasource.generateAbsents())
            },
            contentTwo = {
                TabNoteScreen(DummyDatasource.generateNotes())
            }
        )
    }
}