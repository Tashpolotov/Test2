package com.example.ticket.data.mapper

import com.example.ticket.data.model.alltikets.AllTicketsData
import com.example.ticket.data.model.alltikets.TicketData
import com.example.ticket.data.model.mainscreen.OfferData
import com.example.ticket.data.model.mainscreen.OfferResponseData
import com.example.ticket.data.model.mainscreen.PriceData
import com.example.ticket.data.model.search.TicketOfferResponseData
import com.example.ticket.domain.model.allteickets.AllTickets
import com.example.ticket.domain.model.allteickets.Ticket
import com.example.ticket.domain.model.mainscreen.Offer
import com.example.ticket.domain.model.mainscreen.OfferResponse
import com.example.ticket.domain.model.mainscreen.Price
import com.example.ticket.domain.model.search.TicketOfferResponse

interface DomainMapper {
    fun mapToOfferResponse(data: OfferResponseData): OfferResponse
    fun mapToTicketOfferResponse(data: TicketOfferResponseData): TicketOfferResponse
    fun mapToAllTickets(data: AllTicketsData): AllTickets
    fun mapToTicket(data: TicketData): Ticket
    fun mapToOffer(data: OfferData): Offer
    fun mapToPrice(data: PriceData): Price
}