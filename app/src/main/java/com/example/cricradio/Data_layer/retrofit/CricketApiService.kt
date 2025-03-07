package com.example.cricradio.Data_layer.retrofit

import com.example.cricradio.di.modal.MiniMatchResponse
import com.example.cricradio.di.modal.ValueInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query



interface CricketApiService {
    @GET("/api/v2/match/mini-match-card")
    suspend fun getMiniMatchDetails(
        @Header("Authorization")Authorization: String = "Basic Y3JpY2tldFJhZGlvOmNyaWNrZXRAJCUjUmFkaW8xMjM=",
        @Query("key") key: String = "SA_vs_SL_2024-12-05_1732276435.300452"
    ): Response<MiniMatchResponse>



    @GET("/api/v2/match/venue-info")
    suspend fun getVenueInfo(
        @Header("Authorization") authHeader: String = "Basic Y3JpY2tldFJhZGlvOmNyaWNrZXRAJCUjUmFkaW8xMjM=",
        @Query("key") matchKey: String = "SA_vs_SL_2024-12-05_1732276435.300452"
    ): Response<ValueInfoResponse>

}