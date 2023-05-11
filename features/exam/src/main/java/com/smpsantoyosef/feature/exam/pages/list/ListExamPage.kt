package com.smpsantoyosef.feature.exam

import android.content.res.Configuration
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.smpsantoyosef.common.components.BaseAppBar
import com.smpsantoyosef.common.utils.NavRoute
import com.smpsantoyosef.data.utils.DummyDatasource
import com.smpsantoyosef.entity.Exam
import com.smpsantoyosef.feature.exam.components.ItemExam

@Composable
fun ListExamPage(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            BaseAppBar(
                title = stringResource(com.smpsantoyosef.feature.score.R.string.ujian),
                onClickBack = {navController.popBackStack()},
                elevation = 1.dp){}
        },
    ) { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding),
        ) {
            ExamList(DummyDatasource.generateExams(), navController)
        }
    }
}

@Composable
fun ExamList(data: ArrayList<Exam>, navController: NavHostController) {
    var selected by remember {
        mutableStateOf(0)
    }
    if (data.isNotEmpty()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(data) { exam ->
                ItemExam(data = exam, onValueChange = { selected = exam.id }, selected = selected == exam.id, onItemClick = {
                    Handler(Looper.getMainLooper()).postDelayed({
                        navController.navigate(NavRoute.tokeExamScreen)
                    }, 200)
                })
            }
        }
    } else {
        Text(text = "Data is empty")
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ScoreScreenPreview() {
    val navHostController = rememberNavController()
    ListExamPage(navHostController)
}