package com.example.focus

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import kotlin.math.cos
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.lang.Math.PI
import java.lang.Math.cos
import kotlin.math.sin

@Composable
fun Timer (
    totalTime:Long,
    handleColor:Color,
    inactiveBarColor:Color,
    activeBarColor:Color,
    modifier:Modifier = Modifier,
    initialValue:Float = 0f,
    strokeWidth: Dp = 5.dp
)
{
    var size by remember { mutableStateOf(IntSize.Zero)} //IntSize representing a size with integer width and height values
                                                            //IntSize.Zero simply is width and height equal to zero
    var value by remember {
        mutableStateOf(initialValue)
    }
    var currenttime by remember {
        mutableStateOf(totalTime)
    }
    var isTimerisRunning by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = currenttime, key2 = isTimerisRunning )
    {
        if(currenttime >0 &&isTimerisRunning){
            delay(100L)
            currenttime -=100L
            value = currenttime/totalTime.toFloat()

        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .onSizeChanged {
                size = it
            }
        ) {
            Canvas(modifier = modifier){
                drawArc(
                    color = inactiveBarColor,
                    startAngle = -215f,
                    sweepAngle = 250f,
                    useCenter = false,
                    size = Size(size.width.toFloat(),size.height.toFloat()),
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)

                )
                drawArc(
                    color = activeBarColor,
                    startAngle = -215f,
                    sweepAngle = 250f*value,
                    useCenter = false,
                    size = Size(size.width.toFloat(),size.height.toFloat()),
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)

                )
                val center = Offset(size.width/2f,size.height/2f)
                val beta = (250f * value + 145f) * (PI/180f).toFloat()
                val r  = size.width/2f
                val a  = cos(beta)*r
                val b = sin(beta)*r

                drawPoints(
                    listOf(Offset(center.x +a,center.y+b)),

                    pointMode = PointMode.Points,
                    Color(109121),
                    strokeWidth = (strokeWidth*3f).toPx(),
                    cap = StrokeCap.Round
                )
            }
        Text(
            text = (currenttime / 1000L).toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 44.sp,
            color = Color.White
        )
       Button(
                onClick = {
                          if(currenttime<=0L)
                          {
                              currenttime = totalTime
                              isTimerisRunning = true

                          }else{
                              isTimerisRunning =!isTimerisRunning
                          }
                          },
                modifier = Modifier.align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(
                    if(!isTimerisRunning||currenttime<=0L)
                    {
                        Color.Green
                    }
                    else{
                        Color.Red
                    }
                ),

           ) {
            Text(text = if (isTimerisRunning &&currenttime>=0L) "Stop"
                        else if (!isTimerisRunning&&currenttime>=0L) "Start"
                        else "ReStart"
            )
       }
    }

}
@Preview
@Composable
fun PreviewTimer()
{
    Timer(
        totalTime = 100L*1000L,
        handleColor = Color.Green,
        inactiveBarColor = Color.DarkGray,
        activeBarColor = Color(0xFF37B900),
        modifier = Modifier.size(200.dp)

    )
}
