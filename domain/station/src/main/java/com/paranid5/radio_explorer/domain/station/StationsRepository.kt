package com.paranid5.radio_explorer.domain.station

import io.reactivex.rxjava3.core.Single

interface StationsRepository {
    fun fetchAllStations(): Single<Unit>
}