package com.example.ticket.domain.model.search

import com.example.ticket.domain.model.mainscreen.Price
import com.google.gson.annotations.SerializedName

data class TicketOffer(
    val id: Int,
    val title: String,
    @SerializedName("time_range")
    val timeRange: List<String>?,
    val price: Price
)
