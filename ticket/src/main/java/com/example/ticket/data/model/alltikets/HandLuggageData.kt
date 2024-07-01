package com.example.ticket.data.model.alltikets

import com.google.gson.annotations.SerializedName

data class HandLuggageData(
    @SerializedName("has_hand_luggage")
    val hasHandLuggage: Boolean,
    val size: String?
)