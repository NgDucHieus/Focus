package com.example.focus

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.concurrent.timer


@Composable
fun CountDownTimess(modifier: Modifier = Modifier)
{
    val currentTime by remember {
        mutableStateOf(50)
    }
    var countdownValue by remember {
        mutableStateOf(60L)

    }
    var isCountDown by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = countdownValue, key2 = isCountDown)
    {
        if (countdownValue> 0 && isCountDown) {
            delay(100L)
            countdownValue -= 100L

        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = countdownValue.toString(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
            Button(onClick = {
                    if(countdownValue<=0L){
                        isCountDown = true
                    }
                    else{
                        isCountDown = !isCountDown
                    }
                },
            ) {
                Text("Start")
            }
        }
    }


}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTime()
{
    CountDownTimess()
}