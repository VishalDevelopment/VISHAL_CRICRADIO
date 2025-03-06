package com.example.cricradio.Data_layer.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import androidx.lifecycle.ViewModel
import com.example.cricradio.Data_layer.modal.MiniMatchResponse
import com.example.cricradio.Data_layer.modal.ValueInfoResponse
//import com.example.cricradio.Data_layer.modal.VenueInfo.ValueInfoResponse
import com.example.cricradio.State
import com.example.cricradio.repo.CricketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CricketViewModel @Inject constructor(private val repository: CricketRepository) : ViewModel() {

  private val _miniMatchDetails = MutableStateFlow<State<MiniMatchResponse>>(State.Loading())
   val miniMatchDetails: StateFlow<State<MiniMatchResponse>> = _miniMatchDetails.asStateFlow()

   private val _fullMatchDetails = MutableStateFlow<State<ValueInfoResponse>>(State.Loading())
   val fullMatchDetails: StateFlow<State<ValueInfoResponse>> = _fullMatchDetails.asStateFlow()

   fun fetchMiniMatchDetails() {
        viewModelScope.launch {
          _miniMatchDetails.value = State.Loading()
        _miniMatchDetails.value = repository.getMiniMatchDetails()

        }
    }


    fun fetchFullMatchDetails(matchKey: String) {
        viewModelScope.launch {
            _fullMatchDetails.value = State.Loading()
            _fullMatchDetails.value = repository.getVenueInfo(matchKey)
        }
    }
}