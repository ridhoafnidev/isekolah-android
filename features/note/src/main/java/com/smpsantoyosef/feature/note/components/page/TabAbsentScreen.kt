package com.smpsantoyosef.feature.note.components.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.smpsantoyosef.entity.Absent
import com.smpsantoyosef.feature.note.components.ItemAbsentHistory

@Composable
fun TabAbsentScreen(data: List<Absent>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(data) {absent ->
            ItemAbsentHistory(data = absent)
        }
    }
}