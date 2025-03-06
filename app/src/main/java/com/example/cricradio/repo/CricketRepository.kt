package com.example.cricradio.repo


import android.util.Log
import com.example.cricradio.Data_layer.modal.MiniMatchResponse
import com.example.cricradio.Data_layer.modal.ValueInfoResponse
import com.example.cricradio.Data_layer.retrofit.CricketApiService
import javax.inject.Inject
import javax.inject.Singleton

class CricketRepository @Inject constructor(
    private val apiService: CricketApiService
) {

    suspend fun getMiniMatchDetails(): com.example.cricradio.State<MiniMatchResponse> {
        return try {
            val response = apiService.getMiniMatchDetails()
            Log.d("RESPONSE","${response.body()}")
            if (response.isSuccessful) {
                response.body()?.let {
                    return com.example.cricradio.State.Success(it)
                } ?: com.example.cricradio.State.Error("No data available")
            } else {
                com.example.cricradio.State.Error("API error: ${response.message()}")
            }
        } catch (e: Exception) {
            com.example.cricradio.State.Error("Network error: ${e.localizedMessage}")
        }
    }

    suspend fun getVenueInfo(matchKey: String): com.example.cricradio.State<ValueInfoResponse> {
        return try {
            val response = apiService.getVenueInfo(matchKey)
            if (response.isSuccessful) {
                response.body()?.let {
                    return com.example.cricradio.State.Success(it)
                } ?: com.example.cricradio.State.Error("No data available")
            } else {
                com.example.cricradio.State.Error("API error: ${response.message()}")
            }
        } catch (e: Exception) {
            com.example.cricradio.State.Error("Network error: ${e.localizedMessage}")
        }
    }
}

