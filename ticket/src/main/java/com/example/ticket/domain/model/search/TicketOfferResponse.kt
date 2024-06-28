package com.example.ticket.domain.model.search

import com.example.ticket.domain.model.search.TicketOffer

data class TicketOfferResponse(

    val tickets_offers: List<TicketOffer>,
)