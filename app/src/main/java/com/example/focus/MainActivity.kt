package com.example.focus

import android.os.CountDownTimer
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.focus.ui.theme.FocusTheme
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("RememberReturnType", "UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        // Creating a Simple Scaffold
                // Layout for the application
                Scaffold(

                    // Creating a Top Bar

                    // Creating Content
                    content = {

                        // Creating a Column Layout
                        Column(
                            Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            // Declaring circle radius
                            val radius = 200f

                            // Creating animation
                            val animateFloat = remember { Animatable(0f) }
                            LaunchedEffect(animateFloat) {
                                animateFloat.animateTo(
                                    targetValue = 1f,
                                    animationSpec = tween(
                                        durationMillis = 3000,
                                        easing = LinearEasing
                                    )
                                )
                            }

                            // Creating Arc with useCenter as True
                            Row {
                                Canvas(modifier = Modifier.width(100.dp).height(100.dp)) {
                                    drawArc(
                                        color = Color.Black,
                                        startAngle = 0f,
                                        sweepAngle = 360f * animateFloat.value,
                                        useCenter = true,
                                        size = Size(radius * 2, radius * 2),
                                        style = Stroke(2.0f)
                                    )
                                }
                            }

                            // Adding a Space of height 100dp
                            Spacer(modifier = Modifier.height(100.dp))

                            // Creating Arc with useCenter as False
                            Row {
                                Canvas(modifier = Modifier.width(100.dp).height(100.dp)) {
                                    drawArc(
                                        color = Color.Black,
                                        startAngle = 0f,
                                        sweepAngle = 360f * animateFloat.value,
                                        useCenter = false,
                                        size = Size(radius * 2, radius * 2),
                                        style = Stroke(2.0f)
                                    )
                                }
                            }
                        }
                    }
                )
            }
        }
    }




//
//data class CountdownState(var min: Int, var sec: Int, var values: String)
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    var countdownState by remember { mutableStateOf(CountdownState(10, 0, " ")) }
//
//    DisposableEffect(Unit) {
//        val count = object : CountDownTimer(50000, 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//                countdownState = CountdownState(
//                    ((millisUntilFinished / 60000) % 60).toInt(),
//                    ((millisUntilFinished / 1000) % 60).toInt(),
//                    "${countdownState.min}:${countdownState.sec}"
//                )
//            }
//
//            override fun onFinish() {
//                countdownState = CountdownState(0, 0, "00:00")
//            }
//        }
//
//        count.start()
//
//        onDispose {
//            count.cancel()
//        }
//    }
//
//    Text(
//        text = countdownState.values,
//        fontSize = 30.sp,
//        color = Color.Blue,
//    )
//}
//@Preview (showSystemUi = true, showBackground = true)
//@Composable
//fun SliderMinimalExample() {
//    var sliderPosition:Float by remember { mutableStateOf(0f) }
//    Column {
//        Slider(
//            value = sliderPosition,
//
//            onValueChange = { sliderPosition = it }
//        )
//        Text(text = sliderPosition.toString())
//    }
//}
//@Composable
//fun I2mage()
//{
//    Row {
//        Image(
//            painter = painterResource(id = R.drawable.e501327e09929f2a51f11e1bd649da91),
//            contentDescription = "Andy Rubin",
//            contentScale = ContentScale.Crop,
//
//            modifier = Modifier
//
//                .clip(CircleShape)
//                .border(5.dp, color = Color.Gray)
//        )
//        Text(text = "Duck Spy"
//
//        )
//    }
//}
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun imagePreview()
//{
//    I2mage()
//}
//
//
//@Composable
//fun simplecolumn()
//{
//    Column (modifier = Modifier
//        .fillMaxHeight()
//        .fillMaxWidth(),
//            verticalArrangement = Arrangement.SpaceEvenly,
//            horizontalAlignment = Alignment.End
//
//
//    )
//    {
//        Text(text = "column 1",Modifier.background(Color.Blue))
//        Text(text = "Column 2",Modifier.background(Color.White))
//        Text(text = "Column 3",Modifier.background(Color.Green))
//
//    }
//}
//@Composable
//fun test()
//{
//    var radius by remember { mutableStateOf(0f) }
//}
//
//
//
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun previewColumn()
//{
//    simplecolumn()
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    FocusTheme {
//        Greeting("Android")
//    }
//}
//@Preview (showBackground = true, showSystemUi = true)
//@Composable
//fun Canvastest()
//{
//
//}
