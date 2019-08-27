package com.example.salahtimes.model

import com.google.gson.annotations.SerializedName

data class TodayWeather(
        @SerializedName("pressure")
        val pressure: Any,
        @SerializedName("temperature")
        val temperature: Any
)