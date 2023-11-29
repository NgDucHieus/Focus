package com.example.focus.ui.theme.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
fun Countdown(
    modifier:Modifier = Modifier,
    progressColor: Int? = null,
    progress:Float,
    time:String,
    size:Int =230,
    stroke:Int =4,
    isFullScreen:Boolean = false
)
{
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec, label = ""
    )
    val itemColor = animateColorAsState(
        targetValue = colorResource(if (isFullScreen) R.color.white else R.color.primary),
        animationSpec = tween(durationMillis = 100), label = ""
    )
    val progressBackgroundColor = animateColorAsState(
        targetValue = colorResource(id = progressColor ?: R.color.primary),
        animationSpec = tween(durationMillis = 100), label = ""
    )

}


@Composable
fun CircularProgressIndicatorBackground(
    modifier:Modifier = Modifier,
    color:Color,
    stroke:Int
)
{
    val style = with(LocalDensity.current)
    {
        Stroke(stroke.dp.toPx())
    }

    Canvas(modifier = modifier)
        {
            val innerRadius =(size.minDimension - style.width)/2
            drawArc(
                color = color,
                startAngle =  0f,
                sweepAngle = 360f,
                size = Size(innerRadius *2,innerRadius*2),
                useCenter = false,
                topLeft = Offset((size/2.0f).width - innerRadius,
                                    (size/2.0f).height-innerRadius),
                style = style
            )
        }
    }


@Preview (showBackground = true, showSystemUi = true)
@Composable
fun PreviewCircular()
{
    Surface (
        color = Color(82,126,91,255)
    ){
        CircularProgressIndicatorBackground(color = Color(76,109,82,255), stroke = 10)
    }
}