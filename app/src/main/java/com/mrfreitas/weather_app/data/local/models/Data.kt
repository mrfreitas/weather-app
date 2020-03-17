package com.mrfreitas.weather_app.data.local.models

data class Data(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: ArrayList<WeatherData>,
    val city: City
) {
}