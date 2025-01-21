package com.paranid5.radio_explorer.feature.stations

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.SavedStateHandle
import com.paranid5.radio_explorer.feature.stations.entity.StationUiState

internal class StationsReducer(
    private val savedStateHandle: SavedStateHandle,
) : BaseObservable() {
    companion object {
        private const val KEY_SEARCH_QUERY = "search_query"
        private const val KEY_SEARCHING_ACTIVE = "searching_active"
        private const val KEY_PLAYING_STATION = "playing_station"
    }

    private val searchQueryLiveData: LiveData<String> =
        savedStateHandle.getLiveData(KEY_SEARCH_QUERY, "")

    @get:Bindable
    var searchQuery: String
        get() = searchQueryLiveData.value.orEmpty()
        set(value) {
            savedStateHandle[KEY_SEARCH_QUERY] = value
            notifyPropertyChanged(BR.searchQuery)
        }

    private val isSearchingActiveLiveData: LiveData<Boolean> =
        savedStateHandle.getLiveData(KEY_SEARCHING_ACTIVE, false)

    @get:Bindable
    var isSearchingActive: Boolean
        get() = isSearchingActiveLiveData.value ?: false
        set(value) {
            savedStateHandle[KEY_SEARCHING_ACTIVE] = value
            notifyPropertyChanged(BR.searchingActive)
        }

    private val playingStationLiveData: LiveData<StationUiState?> =
        savedStateHandle.getLiveData(KEY_PLAYING_STATION, null)

    @get:Bindable
    var playingStation: StationUiState?
        get() = playingStationLiveData.value
        set(value) {
            savedStateHandle[KEY_PLAYING_STATION] = value
            notifyPropertyChanged(BR.playingStation)
        }

    private val isPlayingLiveData = MediatorLiveData<Boolean>().apply {
        addSource(playingStationLiveData) {
            value = it != null
            notifyPropertyChanged(BR.playing)
        }
    }

    @get:Bindable
    val isPlaying: Boolean
        get() = isPlayingLiveData.value ?: false
}
