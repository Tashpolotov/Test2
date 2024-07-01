package com.example.ticket.data.model.search

import com.example.ticket.data.model.search.TicketOfferData
import com.example.ticket.domain.model.search.TicketOffer
import com.google.gson.annotations.SerializedName

data class TicketOfferResponseData(
    @SerializedName("tickets_offers")
    val ticketsOffers: List<TicketOffer>,
)