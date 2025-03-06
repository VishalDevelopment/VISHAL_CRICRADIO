package com.example.cricradio.Ui_layer.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cricradio.R

@Composable
@Preview()
fun WeatherCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Weather",
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Weather Icon
                Image(
                    painter = painterResource(id = R.drawable.weather_icon), // Replace with actual image
                    contentDescription = "Weather Icon",
                    modifier = Modifier
                        .size(width = 88.dp, height = 75.dp)
                        .padding(end = 12.dp)
                )

                // Weather Details (Temperature, Condition)
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Pallekele, Sri Lanka",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "25° C",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFD700) // Gold color for temp
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Partly Cloudy",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF5891D4) // Blue color
                    )
                }

                // Divider & Last Updated
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(40.dp)
                            .width(1.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "Last Updated",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "14 Feb, 5:32 PM",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}
