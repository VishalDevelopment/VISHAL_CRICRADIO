package com.example.cricradio.utils

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cricradio.di.modal.ValueInfoResponse

@Composable
fun UmpiresCard(data: ValueInfoResponse?) {
    val umpire1 = data?.responseData?.result?.firstUmpire ?: "Umpire Not Available"
    val umpire2 = data?.responseData?.result?.secoundUmpire ?: "Umpire Not Available"
    val thirdUmpire = data?.responseData?.result?.thirdUmpire ?: "TV Umpire Not Available"
    val referee = data?.responseData?.result?.matchReferee ?: "Referee Not Available"

    Column(
        modifier = Modifier.fillMaxWidth()
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
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    UmpireDetail(title = "Umpire", name = umpire1)
                    Spacer(modifier = Modifier.height(12.dp))
                    UmpireDetail(title = "Third/TV Umpire", name = thirdUmpire)
                }

                Column(modifier = Modifier.weight(1f)) {
                    UmpireDetail(title = "Umpire", name = umpire2)
                    Spacer(modifier = Modifier.height(12.dp))
                    UmpireDetail(title = "Referee", name = referee)
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


