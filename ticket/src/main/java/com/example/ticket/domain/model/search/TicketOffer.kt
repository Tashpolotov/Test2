package com.example.ticket.domain.model.search

import com.example.ticket.domain.model.mainscreen.Price

data class TicketOffer(
    val id: Int,
    val title: String,
    val time_range: List<String>?,
    val price: Price
)
