package com.paranid5.radio_explorer.feature.stations.entity

import android.os.Parcelable
import com.paranid5.radio_explorer.domain.station.Station
import kotlinx.parcelize.Parcelize

@Parcelize
data class StationUiState(
    val title: String,
    val playingUrl: String,
) : Parcelable {
    companion object {
        fun fromDTO(dto: Station) = StationUiState(
            title = dto.title,
            playingUrl = dto.playerUrl,
        )
    }
}
