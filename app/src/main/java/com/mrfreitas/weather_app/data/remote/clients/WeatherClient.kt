package com.mrfreitas.weather_app.data.remote.clients

import android.content.Context
import com.mrfreitas.weather_app.BuildConfig
import com.mrfreitas.weather_app.data.local.models.Data
import com.mrfreitas.weather_app.data.remote.ApiServiceFactory
import io.reactivex.Observable
import com.mrfreitas.weather_app.data.remote.HOST
import com.mrfreitas.weather_app.data.remote.endpoints.WeatherApiInterface

class WeatherClient {
    private val baseUrl = HOST
    fun getWeather(context: Context, cityId: String): Observable<Data?>? {
        return ApiServiceFactory.getRetrofit(context, baseUrl).create(WeatherApiInterface::class.java).executeRemoteQuery(cityId, BuildConfig.API_KEY)
    }
}