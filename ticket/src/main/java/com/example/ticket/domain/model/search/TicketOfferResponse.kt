package com.example.ticket.domain.model.search

import com.example.ticket.domain.model.search.TicketOffer
import com.google.gson.annotations.SerializedName

data class TicketOfferResponse(
    @SerializedName("tickets_offers")
    val ticketsOffers: List<TicketOffer>,
)