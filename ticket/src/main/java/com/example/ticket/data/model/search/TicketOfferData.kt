package com.example.ticket.data.model.search

import com.example.ticket.data.model.mainscreen.PriceData
import com.example.ticket.domain.model.mainscreen.Price
import com.google.gson.annotations.SerializedName

data class TicketOfferData(
    val id: Int,
    val title: String,
    @SerializedName("time_range")
    val timeRange: List<String>?,
    val price: Price
)
