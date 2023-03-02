package com.smpsantoyosef.score.components

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.smpsantoyosef.data.utils.DummyDatasource
import com.smpsantoyosef.entity.Score
import com.smpsantoyosef.score.R

@Composable
fun ScoreScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                title = {
                    Text(text = stringResource(id = R.string.label_nilai))
                },
            )
        },
    ) { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding),
        ) {
            ScoreList(DummyDatasource.generateScore())
        }
    }
}

@Composable
fun ScoreList(data: ArrayList<Score>) {
    val context = LocalContext.current

    if (data.isNotEmpty()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(data) { score ->
                ItemScore(data = score, onItemClick = {
                    Toast.makeText(context, "Click ${score.course}", Toast.LENGTH_LONG).show()
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
    ScoreScreen(navHostController)
}