package com.example.cricradio.Data_layer.repo


import android.util.Log
import com.example.cricradio.Data_layer.modal.MiniMatchResponse
import com.example.cricradio.Data_layer.modal.ValueInfoResponse
import com.example.cricradio.Data_layer.retrofit.CricketApiService
import com.example.cricradio.common.State
import javax.inject.Inject

class CricketRepository @Inject constructor(
    private val apiService: CricketApiService
) {

    suspend fun getMiniMatchDetails(): State<MiniMatchResponse> {
        return try {
            val response = apiService.getMiniMatchDetails()
            Log.d("RESPONSE","${response.body()}")
            if (response.isSuccessful) {
                response.body()?.let {
                    return State.Success(it)
                } ?: State.Error("No data available")
            } else {
                State.Error("API error: ${response.message()}")
            }
        } catch (e: Exception) {
            State.Error("Network error: ${e.localizedMessage}")
        }
    }

    suspend fun getVenueInfo(): State<ValueInfoResponse> {
        return try {
            val response = apiService.getVenueInfo()
            Log.d("RESPONSE","${response.body()}")
            if (response.isSuccessful) {
                response.body()?.let {
                    return State.Success(it)
                } ?: State.Error("No data available")
            } else {
                State.Error("API error: ${response.message()}")
            }
        } catch (e: Exception) {
            State.Error("Network error: ${e.localizedMessage}")
        }
    }
}

