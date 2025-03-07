package com.example.cricradio.Data_layer.module

import com.example.cricradio.Data_layer.retrofit.CricketApiService
import com.example.cricradio.Data_layer.repo.CricketRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "http://3.6.243.12:5001"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCricketApiService(retrofit: Retrofit): CricketApiService {
        return retrofit.create(CricketApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCricketRepository(apiService: CricketApiService): CricketRepository {
        return CricketRepository(apiService)
    }
}