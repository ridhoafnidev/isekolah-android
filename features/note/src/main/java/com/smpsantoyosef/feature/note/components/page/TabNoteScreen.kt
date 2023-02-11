package com.smpsantoyosef.feature.note.components.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.smpsantoyosef.entity.Note
import com.smpsantoyosef.feature.note.components.ItemNoteHistory

@Composable
fun TabNoteScreen(data: List<Note>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(data) {note ->
            ItemNoteHistory(data = note)
        }
    }
}