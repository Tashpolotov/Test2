package com.example.ticket.domain.model.allteickets

import com.google.gson.annotations.SerializedName

data class HandLuggage(
    @SerializedName("has_hand_luggage")
    val hasHandLuggage: Boolean,
    val size: String?
)