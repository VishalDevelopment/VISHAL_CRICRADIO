package com.example.cricradio.Ui_layer.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.cricradio.R

@Composable
@Preview(showBackground = true, backgroundColor = 0)

fun VenueInfoScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())) {
        CricketScoreCard()
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0A192F)),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(16.dp) // Increased border radius
        ) {




            Box {
                Image(
                    painter = painterResource(id = R.drawable.bg_img), // Replace with your image
                    contentDescription = "Background Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp), // Adjust height as needed
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Text Field with requested text
        Text(
            text = "Pallekele International Cricket Stadium, Pallekele Sri Lanka, Sri Lanka",
            fontSize = 16.sp,
            color = Color(0xFF5891D4),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Text Field with requested text
        Text(
            text = "2nd ODI  Afghanistan Tour of Sri Lanka 2024",
            fontSize = 16.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold
        )
//        14 Feb 2024, Thursday 2:30 PM
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "14 Feb 2024, Thursday 2:30 PM",
            fontSize = 14.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.08f),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0A192F)),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(16.dp) // Increased border radius
        ){

            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "PAK won the toss and chose to bat first",
                    fontSize = 10.sp,
                    color = Color(0xFFFAC86E),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(3.dp)
                        .fillMaxWidth()
                        .padding(start = 5.dp)
                )
            }
        }
        UmpiresCard()
        Spacer(modifier = Modifier.height(8.dp))
        WeatherCard()
        Spacer(modifier = Modifier.height(8.dp))
        VenueStatsUI()
    }
}


@Composable
fun UmpiresCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Text(
            text = "Umpires",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)), // Dark background
            elevation = CardDefaults.cardElevation(2.dp),
            shape = RoundedCornerShape(12.dp) // Rounded corners
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    UmpireDetail(title = "Umpire", name = "Michael Gough")
                    UmpireDetail(title = "Umpire", name = "Lyndon Hannibal")
                }

                Spacer(modifier = Modifier.height(12.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    UmpireDetail(title = "Third/TV Umpire", name = "Michael Gough")
                    UmpireDetail(title = "Referee", name = "Chris Broad")
                }
            }
        }
    }
}

@Composable
fun UmpireDetail(title: String, name: String) {
    Column {
        Text(
            text = title,
            fontSize = 12.sp,
            color = Color.Gray
        )
        Text(
            text = name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
