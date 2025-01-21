package com.paranid5.radio_explorer.data.station

import androidx.annotation.Keep
import com.paranid5.radio_explorer.data.GOOGLE_API_KEY
import com.paranid5.radio_explorer.data.GOOGLE_SEARCH_ENGINE
import com.paranid5.radio_explorer.data.station.dto.QueryThumbnailResponse
import com.paranid5.radio_explorer.domain.station.Station
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

@Keep
internal interface StationsApi {
    companion object {
        const val IMAGE_QUERY = "query"
    }

    @GET("https://espradio.ru/stream_list.json")
    fun getAllStations(): Single<List<Station>>

    @GET("https://www.googleapis.com/customsearch/v1?q={$IMAGE_QUERY}&searchType=image&key=$GOOGLE_API_KEY&cx=$GOOGLE_SEARCH_ENGINE")
    fun getQueryThumbnail(@Path(IMAGE_QUERY) imageQuery: String): Single<QueryThumbnailResponse>
}
