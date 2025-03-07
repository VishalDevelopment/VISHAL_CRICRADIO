package com.example.cricradio.Ui_layer.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.cricradio.Ui_layer.CricketViewModel
import com.example.cricradio.R

import com.example.cricradio.common.State
import com.example.cricradio.utils.CricketScoreCard
import com.example.cricradio.utils.UmpiresCard
import com.example.cricradio.utils.VenueStatsUI
import com.example.cricradio.utils.WeatherCard

@Composable
fun VenueInfoScreen(viewmodel: CricketViewModel = hiltViewModel()) {
    val match = viewmodel.miniMatchDetails.collectAsState()
    val full = viewmodel.fullMatchDetails.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        when (val matchState = match.value) {
            is State.Loading -> {
                Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                    Text(text = "Loading content...", color = Color.White)
                }
            }
            is State.Error -> {
                Text(text = "Error: ${matchState.message}", color = Color.Red)
            }
            is State.Success -> {
                matchState.data?.responseData?.result?.teams?.let { teams ->
                    CricketScoreCard(
                        teams = teams,
                        status = matchState.data?.responseData.result.status ?: "Match Status Unavailable",
                        now = matchState.data?.responseData.result.now,
                        currentBattingTeam = matchState.data.responseData.result.settingObj?.currentTeam
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        when (val fullState = full.value) {
            is State.Loading -> {
            }
            is State.Error -> {
                Text(text = "Error: ${fullState.message}", color = Color.Red)
            }
            is State.Success -> {
                fullState.data?.responseData?.result?.let { matchDetails ->
                    // Stadium Image
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF0A192F)),
                        elevation = CardDefaults.cardElevation(8.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Box {
                            AsyncImage(
                                model = matchDetails.venueDetails?.photo ?: R.drawable.bg_img,
                                contentDescription = "Stadium Background",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    // Venue Name
                    Text(
                        text = matchDetails.venueDetails?.knownAs ?: "Venue Not Available",
                        fontSize = 16.sp,
                        color = Color(0xFF5891D4),
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    // Match Details
                    Text(
                        text = matchDetails.related_name ?: "Match Info Not Available",
                        fontSize = 16.sp,
                        color = Color.LightGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = matchDetails.start_date?.str ?: "Date & Time Not Available",
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
                        shape = RoundedCornerShape(2.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(Color(0xFF121212), Color(0x0DFFFFFF))
                                    )
                                ),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = matchDetails.toss?.str ?: "Toss Info Not Available",
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

                    Spacer(modifier = Modifier.height(8.dp))

                    UmpiresCard(fullState.data)

                    Spacer(modifier = Modifier.height(8.dp))

                    WeatherCard(fullState.data)

                    Spacer(modifier = Modifier.height(8.dp))

                    VenueStatsUI(fullState.data)
                }
            }
        }
    }
}







