package com.mrfreitas.weather_app.data.local.models

data class WeatherData(
    val dt: Long,
    val main: MainWeatherData,
    val weather: Weather,
    val clouds: Clouds,
    val wind: Wind,
    val dt_txt: String
) {
}