package com.paranid5.radio_explorer.data.station

import androidx.annotation.Keep
import com.paranid5.radio_explorer.domain.station.Station
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

@Keep
internal interface StationsApi {
    @GET("https://espradio.ru/stream_list.json")
    fun getAllStations(): Single<List<Station>>
}
