package com.mrfreitas.weather_app.data.local.models

data class City(
    val id: Int,
    val name: String,
    val coord: Coordinates,
    val country: String,
    val sunrise: Int,
    val sunset: Int
) {
}