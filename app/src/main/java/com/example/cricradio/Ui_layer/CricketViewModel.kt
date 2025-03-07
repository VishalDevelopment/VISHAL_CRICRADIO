package com.example.cricradio.Ui_layer

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import androidx.lifecycle.ViewModel
import com.example.cricradio.Data_layer.modal.MiniMatchResponse
import com.example.cricradio.Data_layer.modal.ValueInfoResponse
import com.example.cricradio.common.State
//import com.example.cricradio.Data_layer.modal.VenueInfo.ValueInfoResponse
import com.example.cricradio.Data_layer.repo.CricketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
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

    init {
        viewModelScope.launch {
            coroutineScope {
                val miniMatchDeferred = async { fetchMiniMatchDetails() }
                val fullMatchDeferred = async { fetchFullMatchDetails() }
                miniMatchDeferred.await()
                fullMatchDeferred.await()
            }
        }
    }


    private suspend fun fetchMiniMatchDetails() {
        _miniMatchDetails.value = State.Loading()
        _miniMatchDetails.value = repository.getMiniMatchDetails()
    }

    private suspend fun fetchFullMatchDetails() {
        _fullMatchDetails.value = State.Loading()
        _fullMatchDetails.value = repository.getVenueInfo()
    }
}
