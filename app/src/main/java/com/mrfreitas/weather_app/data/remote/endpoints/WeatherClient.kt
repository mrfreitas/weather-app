package com.mrfreitas.weather_app.data.remote.endpoints

import com.mrfreitas.weather_app.data.local.models.Data
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherClient {

    @GET("/data/2.5/forecast")
    fun executeRemoteQuery(@Query("cityId") cityId: String?, @Query("appid") appid: String?): Observable<Data?>?

}