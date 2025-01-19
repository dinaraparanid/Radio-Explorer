package com.paranid5.radio_explorer.data.station

import com.paranid5.radio_explorer.domain.station.StationsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class StationsRepositoryImpl @Inject constructor(
    private val api: StationsApi,
) : StationsRepository {

    override fun fetchAllStations(): Single<Unit> =
        api.getAllStations()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { stations ->
                println("TEST $stations")
                // TODO: store stations to Room db
            }
}