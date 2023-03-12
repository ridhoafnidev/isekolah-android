package com.smpsantoyosef.feature.exam.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smpsantoyosef.common.components.BaseText
import com.smpsantoyosef.common.components.FontType
import com.smpsantoyosef.entity.Exam
import com.smpsantoyosef.isekolah.ui.theme.Neutral100
import com.smpsantoyosef.isekolah.ui.theme.Primary
import kotlinx.coroutines.launch

@Composable
fun <T> ItemExamDetail(
    data: T,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onValueChange: (Int) -> Unit = {},
    onItemClick: (Exam) -> Unit = {},
) {
    val exam = data as Exam
    val scaleA = remember { Animatable(initialValue = 1f) }
    val scaleB = remember { Animatable(initialValue = 1f) }
    val clickEnabled = remember { mutableStateOf(true) }

    LaunchedEffect(key1 = selected) {
        if (selected) {
            clickEnabled.value = false
            val animateA = launch {
                scaleA.animateTo(
                    targetValue = 0.3f,
                    animationSpec = tween(
                        durationMillis = 50
                    )
                )
                scaleA.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
            }
            val animateB = launch {
                scaleB.animateTo(
                    targetValue = 0.9f,
                    animationSpec = tween(
                        durationMillis = 50
                    )
                )
                scaleB.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessHigh
                    )
                )
            }
            animateA.join()
            animateB.join()
            clickEnabled.value = true
        }
    }

    Column(
        modifier = modifier
            .scale(scaleB.value)
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable {
                onItemClick(exam)
                onValueChange(exam.id)
            }
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                .background(color = Primary),
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
            ) {
                Column(
                    modifier = modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.Start,
                ) {
                    BaseText(
                        text = "MATA PELAJARAN".uppercase(),
                        modifier = modifier.fillMaxWidth(),
                        fontColor = Color.White,
                        fontFamily = FontType.MEDIUM,
                        fontSize = 10.sp
                    )
                    BaseText(
                        text = exam.course,
                        modifier = modifier
                            .padding(top = 4.dp)
                            .fillMaxWidth(),
                        fontColor = Color.White,
                        fontFamily = FontType.MEDIUM,
                        fontSize = 16.sp
                    )
                }
                Box(
                    modifier = modifier
                        .scale(scaleA.value)
                        .background(color = Color.White, shape = RoundedCornerShape(8.dp)),

                    ) {
                    BaseText(text= exam.time.uppercase(), fontColor = Color.Black, modifier = modifier.padding(horizontal = 12.dp, vertical = 2.dp))
                }
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Neutral100,
                    shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                )
                .clip(shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                .background(color = Color.White),
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Event,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = modifier.size(15.dp)
                )
                BaseText(
                    text = exam.dateTime,
                    modifier = modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth(),
                    fontColor = Color.Black,
                    fontFamily = FontType.MEDIUM,
                    fontSize = 10.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun ItemExamDetailPreview() {
    ItemExamDetail(data =
        Exam(
            id = 0,
            course="Ilmu Pengetahuan Alam",
            time="90 Menit",
            dateTime = "Rabu, 9 Februari 2023 - 13:30"
        )
    )
}

