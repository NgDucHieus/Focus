package com.example.focus.ui.theme

import android.os.CountDownTimer
import android.os.SystemClock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.withFrameMillis
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive



@Composable
fun rememberCountdownTimerState(
    initialMillis: Long,
    step: Long = 1000
): MutableState<Long> {
    val timeLeft = remember { mutableStateOf(initialMillis) }
    LaunchedEffect(initialMillis, step) {
        val startTime = withFrameMillis { it }
        while (isActive && timeLeft.value > 0) {
            val duration = withFrameMillis { time ->
                (time - startTime).coerceAtLeast(0)
            }
            timeLeft.value = (initialMillis - duration).coerceAtLeast(0)
            delay(step.coerceAtMost(timeLeft.value))
        }
    }
    return timeLeft
}
@Preview
@Composable
fun PreviewCountdown()
{
    Text(text = rememberCountdownTimerState(initialMillis = 3000).toString())
}
