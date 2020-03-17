package com.mrfreitas.weather_app.data.local.models

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
) {
}