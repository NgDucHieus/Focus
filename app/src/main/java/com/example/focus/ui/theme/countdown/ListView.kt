package com.example.focus.ui.theme.countdown

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.focus.R


@SuppressLint("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun customListView(context:Context)
{
   lateinit var sessionList: List<ListModel>
   sessionList =ArrayList<ListModel>()

    sessionList = sessionList + ListModel("5")
    sessionList = sessionList + ListModel("10")
    sessionList = sessionList + ListModel("15")
    sessionList = sessionList + ListModel("20")
    sessionList = sessionList + ListModel("25")
    sessionList = sessionList + ListModel("30")
    sessionList = sessionList + ListModel("35")
    sessionList = sessionList + ListModel("40")


    LazyRow{
        itemsIndexed(sessionList){ index, item ->
           Card(
               onClick = {
                   Toast.makeText(
                        context,
                       sessionList[index].languageName +"Selected ..",
                       Toast.LENGTH_SHORT
                   ).show()
               },
               modifier = Modifier
                   .padding(8.dp)
                   .height(50.dp)
                   .width(50.dp),
               elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),

           )
           {

                    Text(
                        text = sessionList[index].languageName,
                        modifier = Modifier
                            .padding(15.dp)
                            .size(50.dp)
                        ,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
           }
        }
    }



@Preview
@Composable
fun PreviewContent()
{
//    customListView()
}
