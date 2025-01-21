package com.paranid5.radio_explorer.data.station.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QueryThumbnailResponse(val items: List<Item>) {

    @Serializable
    data class Item(@SerialName("link") val link: String?)

    val thumbnailUrl = items.firstOrNull()?.link
}
