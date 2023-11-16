package com.example.focus.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.focus.R
import java.lang.Math.atan2
import java.lang.Math.cos
import java.lang.Math.sin
import kotlin.math.atan2
@Composable
fun Content() {

    var radius by remember {
        mutableStateOf(0f)
    }

    var shapeCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var handleCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var angle by remember {
        mutableStateOf(0.0)
    }

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    handleCenter += dragAmount
                    angle = getRotationAngle(handleCenter, shapeCenter)
                    change.consume()
                }
            }
            .padding(60.dp)

    ) {
        shapeCenter = center
        radius = size.minDimension / 2

        val x = (shapeCenter.x + cos(Math.toRadians(angle)) * radius).toFloat()
        val y = (shapeCenter.y + sin(Math.toRadians(angle)) * radius).toFloat()
        handleCenter = Offset(x, y)
        drawCircle(color = Color(0xDFC0CC82),  radius = radius)
        drawCircle(color = Color(0xFFFAEB9F),  radius = radius, style = Stroke(20f))
        drawArc(
            color = Color(0xDF80DF2D),
            startAngle = 0f,
            sweepAngle = angle.toFloat(),
            useCenter = false,
            style = Stroke(20f)
        )

        drawCircle(color = Color(0xDF80DF2D), center = handleCenter, radius = 35f)
    }
    Text(text = "angle:$angle")


}

private fun getRotationAngle(currentPosition: Offset, center: Offset): Double {
    val (dx, dy) = currentPosition - center
    val theta = atan2(dy, dx).toDouble()

    var angle = Math.toDegrees(theta)

    if (angle < 0) {
        angle += 360.0
    }
    return angle

}

@Preview (showSystemUi = true, showBackground = true , backgroundColor =0xFF4F6F52,
    device = "spec:width=1080px,height=2340px,dpi=440"
)

@Composable
fun previewContent()
{
    Content()
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun CirlcleCanvas()
{
    Canvas(
        modifier = Modifier
            .border(color = Color.Magenta, width = 2.dp)
            .aspectRatio(1f)
            .padding(30.dp)
    ) {
        drawArc(
            color = Color.Cyan,
            startAngle = 0f,
            sweepAngle = 90f,
            useCenter = true
        )
    }
}
