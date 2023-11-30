package com.example.focus.ui.theme.countdown

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.focus.R

@Composable
fun CountDownSetTime(
    modifier:Modifier = Modifier,
    progressColor: Int?=null,
    time:String,
    stroke:Int =4
)
{
    val progressBackgroundColor = animateColorAsState(
        targetValue = colorResource(id = progressColor ?: R.color.primary),
        animationSpec = tween(durationMillis = 100)
    )

    Column (modifier = modifier){
        Box(modifier = modifier)
        {
        CircularProgressIndicatorBackground(color = progressBackgroundColor.value,
            stroke = stroke )

        }

    }
}



@Composable
fun CircularProgressIndicatorBackground(
    modifier: Modifier = Modifier,
    color:Color,
    stroke:Int
)
{
val style =with(LocalDensity.current)
    {
        Stroke(stroke.dp.toPx())
    }
    Canvas(modifier = modifier)
    {
        val innerRadius =(size.minDimension/2)
        drawArc(
            color = color,
            startAngle = 0f,
            sweepAngle = 360f,
            useCenter = false,
            size = Size(innerRadius*2,innerRadius*2),
            topLeft = Offset(
                (size/2.0f).width - innerRadius,
                (size/2.0f).height - innerRadius
            ),
            style = style

        )

    }
}

@Preview ()
@Composable
fun PDreview()
{
CircularProgressIndicatorBackground(color = Color(45, 144, 40), stroke =10 )
}
