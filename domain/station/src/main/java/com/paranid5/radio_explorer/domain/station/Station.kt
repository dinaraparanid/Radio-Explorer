package com.paranid5.radio_explorer.domain.station

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Station(
    @SerialName("name") val title: String,
    @SerialName("url") val playerUrl: String,
)
