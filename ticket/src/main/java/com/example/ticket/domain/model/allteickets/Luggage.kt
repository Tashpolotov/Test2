package com.example.ticket.domain.model.allteickets

import com.google.gson.annotations.SerializedName


data class Luggage(
    @SerializedName("has_luggage")
    val hasLuggage: Boolean,
    val price: PriceX?
)