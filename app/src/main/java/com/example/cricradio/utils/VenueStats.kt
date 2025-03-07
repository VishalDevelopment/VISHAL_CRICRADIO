package com.example.cricradio.utils


import androidx.compose.foundation.BorderStroke
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
import com.example.cricradio.Data_layer.modal.ValueInfoResponse

data class VenueStats(
    val matchesPlayed: Int,
    val lowestDefended: Int,
    val highestChased: Int,
    val winBatFirst: Int,
    val winBallFirst: Int,
    val firstInningsStats: InningsStats,
    val secondInningsStats: InningsStats
)

data class InningsStats(
    val avgScore: Int,
    val highestScore: Int,
    val lowestScore: Int,
    val paceWickets: Pair<Int, String>,
    val spinWickets: Pair<Int, String>
)

@Composable
fun VenueStatsUI(fullMatchDetails: ValueInfoResponse?) {
    val venueStats = fullMatchDetails?.responseData?.result?.venueStats

    val stats = VenueStats(
        matchesPlayed = venueStats?.matchesPlayed ?: 0,
        lowestDefended = venueStats?.lowestDefended ?: 0,
        highestChased = venueStats?.highestChased ?: 0,
        winBatFirst = venueStats?.batFirstWins ?: 0,
        winBallFirst = venueStats?.ballFirstWins ?: 0,
        firstInningsStats = InningsStats(
            avgScore = venueStats?.battingFirst?.averageScore ?: 0,
            highestScore = venueStats?.battingFirst?.highestScore ?: 0,
            lowestScore = venueStats?.battingFirst?.lowestScore ?: 0,
            paceWickets = Pair(venueStats?.battingFirst?.paceWickets ?: 0, "N/A"),
            spinWickets = Pair(venueStats?.battingFirst?.spinWickets ?: 0, "N/A")
        ),
        secondInningsStats = InningsStats(
            avgScore = venueStats?.battingSecond?.averageScore ?: 0,
            highestScore = venueStats?.battingSecond?.highestScore ?: 0,
            lowestScore = venueStats?.battingSecond?.lowestScore ?: 0,
            paceWickets = Pair(venueStats?.battingSecond?.paceWickets ?: 0, "N/A"),
            spinWickets = Pair(venueStats?.battingSecond?.spinWickets ?: 0, "N/A")
        )
    )
Column {
        Text(
            "Venue Stats",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color.White.copy(alpha = 0.6f))
        ) {
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                StatsRow("Matches Played", stats.matchesPlayed.toString())
                Divider(color = Color(0xFF817C7C), thickness = 1.dp)
                StatsRow("Lowest Defended", stats.lowestDefended.toString())
                Divider(color = Color(0xFF817C7C), thickness = 1.dp)
                StatsRow("Highest Chased", stats.highestChased.toString())
                Divider(color = Color(0xFF817C7C), thickness = 1.dp)
                StatsRow("Win Bat First", stats.winBatFirst.toString())
                Divider(color = Color(0xFF817C7C), thickness = 1.dp)
                StatsRow("Win Ball First", stats.winBallFirst.toString())
                Divider(color = Color(0xFF817C7C), thickness = 1.dp)

                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A).copy(alpha = 0.1f)),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row {
                            Text("1st Inn", color = Color.White, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.padding(horizontal = 18.dp))
                            Text("2nd Inn", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }
                }

                StatsRowWithTwoColumns(
                    "Avg Score",
                    stats.firstInningsStats.avgScore.toString(),
                    stats.secondInningsStats.avgScore.toString()
                )
                Divider(color = Color(0xFF817C7C), thickness = 1.dp)

                StatsRowWithTwoColumns(
                    "Highest Score",
                    stats.firstInningsStats.highestScore.toString(),
                    stats.secondInningsStats.highestScore.toString()
                )
                Divider(color = Color(0xFF817C7C), thickness = 1.dp)

                StatsRowWithTwoColumns(
                    "Lowest Score",
                    stats.firstInningsStats.lowestScore.toString(),
                    stats.secondInningsStats.lowestScore.toString()
                )
                Divider(color = Color(0xFF817C7C), thickness = 1.dp)

                StatsRowWithTwoColumns(
                    "Pace Wickets",
                    "${stats.firstInningsStats.paceWickets.first} (${stats.firstInningsStats.paceWickets.second})",
                    "${stats.secondInningsStats.paceWickets.first} (${stats.secondInningsStats.paceWickets.second})"
                )
                Divider(color = Color(0xFF817C7C), thickness = 1.dp)

                StatsRowWithTwoColumns(
                    "Spin Wickets",
                    "${stats.firstInningsStats.spinWickets.first} (${stats.firstInningsStats.spinWickets.second})",
                    "${stats.secondInningsStats.spinWickets.first} (${stats.secondInningsStats.spinWickets.second})"
                )
            }
        }
    }
}


@Composable
fun StatsRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = Color.White, fontSize = 14.sp)
        Text(value, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
    Spacer(modifier = Modifier.height(6.dp))
}

@Composable
fun StatsRowWithTwoColumns(label: String, first: String, second: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = Color.White, fontSize = 14.sp)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.width(120.dp)
        ) {
            Text(first, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text(second, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
    }
    Spacer(modifier = Modifier.height(6.dp))
}
