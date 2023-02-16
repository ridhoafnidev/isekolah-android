package com.smpsantoyosef.feature.absent.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smpsantoyosef.common.components.BaseText
import com.smpsantoyosef.isekolah.ui.theme.Primary

@Composable
fun AbsentRadioButton(items: List<String>, modifier: Modifier = Modifier) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(items[0]) }
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        items.forEach { mItem ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(end = 16.dp)
            ) {
                RadioButton(
                    selected = (selectedOption == mItem),
                    onClick = { onOptionSelected(mItem) },
                    enabled = true,
                    colors = RadioButtonDefaults.colors(selectedColor = Primary, unselectedColor = Color.Gray)
                )
                BaseText(text = mItem, fontSize = 12.sp, modifier = modifier)
            }
        }
    }
}

@Preview
@Composable
fun AbsentRadioButtonPreview() {
    Surface() {
        AbsentRadioButton(listOf("Hadir", "Sakit", "Alfa"))
    }
}