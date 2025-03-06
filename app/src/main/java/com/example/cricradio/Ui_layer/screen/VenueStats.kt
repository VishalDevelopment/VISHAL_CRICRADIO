package com.example.cricradio.Ui_layer.screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
@Preview
fun VenueStatsUI() {
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF121212), Color(0xFFFFFF0D)),
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    )

    val stats = VenueStats(
        matchesPlayed = 25,
        lowestDefended = 25,
        highestChased = 25,
        winBatFirst = 25,
        winBallFirst = 25,
        firstInningsStats = InningsStats(320, 320, 320, Pair(32, "62%"), Pair(22, "43%")),
        secondInningsStats = InningsStats(120, 120, 120, Pair(22, "43%"), Pair(32, "62%"))
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
            modifier = Modifier
                .fillMaxWidth()
            ,        colors = CardDefaults.cardColors(containerColor =  Color(0xFF1A1A1A)), // Slightly lighter than before
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color.White.copy(alpha = 0.6f)) // White border with slight transparency
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {


                StatsRow("Matches Played", stats.matchesPlayed.toString())
                StatsRow("Lowest Defended", stats.lowestDefended.toString())
                StatsRow("Highest Chased", stats.highestChased.toString())
                StatsRow("Win Bat First", stats.winBatFirst.toString())
                StatsRow("Win Ball First", stats.winBallFirst.toString())

                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A).copy(alpha = 0.1f)),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row{
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
                StatsRowWithTwoColumns(
                    "Highest Score",
                    stats.firstInningsStats.highestScore.toString(),
                    stats.secondInningsStats.highestScore.toString()
                )
                StatsRowWithTwoColumns(
                    "Lowest Score",
                    stats.firstInningsStats.lowestScore.toString(),
                    stats.secondInningsStats.lowestScore.toString()
                )
                StatsRowWithTwoColumns(
                    "Pace Wickets",
                    "${stats.firstInningsStats.paceWickets.first} (${stats.firstInningsStats.paceWickets.second})",
                    "${stats.secondInningsStats.paceWickets.first} (${stats.secondInningsStats.paceWickets.second})"
                )
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
