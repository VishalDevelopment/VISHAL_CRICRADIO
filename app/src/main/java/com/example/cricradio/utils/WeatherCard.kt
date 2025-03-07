package com.example.cricradio.utils


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cricradio.di.modal.ValueInfoResponse
import com.example.cricradio.R
@Composable
fun WeatherCard(fullMatchDetails: ValueInfoResponse?) {
    // Extract Weather Data from API
    val weather = fullMatchDetails?.responseData?.result?.weather
    val location = weather?.location ?: "Location Not Available"
    val temperature = weather?.temp_c ?: 0.0
    val condition = weather?.condition?.text ?: "Condition Not Available"
    val weatherIconUrl = weather?.condition?.icon // ✅ URL for the weather icon
    val lastUpdated = weather?.last_updated ?: "Not Updated"

    Column(
        modifier = Modifier.fillMaxWidth()
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
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Weather Icon (from API)
                AsyncImage(
                    model = weatherIconUrl ?: R.drawable.weather_icon, // Use API image, fallback to local
                    contentDescription = "Weather Icon",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(end = 12.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = location,
                        fontSize = 10.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "$temperature° C",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFD700) // Gold color for temp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = condition,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF5891D4) // Blue color
                    )
                }

                // Divider
                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .height(40.dp)
                        .width(1.dp)
                        .padding(horizontal = 12.dp) // Adds spacing
                )

                // Last Updated Section
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Last Updated",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = lastUpdated,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

