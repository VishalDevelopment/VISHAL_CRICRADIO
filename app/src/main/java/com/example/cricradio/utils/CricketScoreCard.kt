package com.example.cricradio.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import coil.compose.AsyncImage
import com.example.cricradio.Data_layer.modal.Now
import com.example.cricradio.Data_layer.modal.Teams
import com.example.cricradio.R

@Composable
fun CricketScoreCard(teams: Teams, status: String, now: Now?, currentBattingTeam: String?) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0A192F)),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = teams.a.logo,
                        contentDescription = "${teams.a.name} Flag",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = teams.a.shortName, color = Color.White, fontWeight = FontWeight.Bold)

                    if (currentBattingTeam == "a") {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cricket_bat),
                            contentDescription = "Batting Icon",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Text(
                    text = "Vs",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = teams.b.logo,
                        contentDescription = "${teams.b.name} Flag",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = teams.b.shortName, color = Color.White, fontWeight = FontWeight.Bold)

                    if (currentBattingTeam == "b") {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cricket_bat),
                            contentDescription = "Batting Icon",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${teams.a.a_1_score?.runs ?: 0}/${teams.a.a_1_score?.wickets ?: 0}",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "${teams.a.a_1_score?.overs ?: "-"} Overs",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${teams.b.b_1_score?.runs ?: 0}/${teams.b.b_1_score?.wickets ?: 0}",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "${teams.b.b_1_score?.overs ?: "-"} Overs",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Divider(color = Color(0xFF224976), thickness = 0.5.dp)

            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "CRR: ${now?.run_rate ?: "-"}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00C0FF)
                )
                Text(
                    text = status,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}


