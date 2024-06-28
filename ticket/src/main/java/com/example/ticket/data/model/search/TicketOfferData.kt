package com.example.ticket.data.model.search

import com.example.ticket.data.model.mainscreen.PriceData

data class TicketOfferData(
    val id: Int,
    val title: String,
    val time_range: List<String>?,
    val price: PriceData
)
