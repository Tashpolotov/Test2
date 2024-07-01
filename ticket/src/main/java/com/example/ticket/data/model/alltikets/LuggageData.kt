package com.example.ticket.data.model.alltikets

import com.example.ticket.domain.model.allteickets.PriceX
import com.google.gson.annotations.SerializedName

data class LuggageData(
    @SerializedName("has_luggage")
    val hasLuggage: Boolean,
    val price: PriceX?
)