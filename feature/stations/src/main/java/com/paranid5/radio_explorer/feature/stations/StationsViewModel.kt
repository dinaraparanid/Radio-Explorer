package com.paranid5.radio_explorer.feature.stations

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StationsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    internal val reducer = StationsReducer(savedStateHandle)
}
