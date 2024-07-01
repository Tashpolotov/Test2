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

class DefaultDomainMapper : DomainMapper {
    override fun mapToOfferResponse(data: OfferResponseData): OfferResponse {
        return OfferResponse(
            data.offers.map { offerData ->
                Offer(
                    offerData.id,
                    offerData.title,
                    offerData.town,
                    Price(offerData.price.value)
                )
            }
        )
    }

    override fun mapToTicketOfferResponse(data: TicketOfferResponseData): TicketOfferResponse {
        return TicketOfferResponse(data.ticketsOffers)
    }

    override fun mapToAllTickets(data: AllTicketsData): AllTickets {
        return AllTickets(
            data.tickets.map { ticketData ->
                Ticket(
                    ticketData.arrival,
                    ticketData.badge,
                    ticketData.company,
                    ticketData.departure,
                    ticketData.handLuggage,
                    ticketData.hasTransfer,
                    ticketData.hasVisaTransfer,
                    ticketData.id,
                    ticketData.isExchangable,
                    ticketData.isReturnable,
                    ticketData.luggage,
                    ticketData.price,
                    ticketData.providerName
                )
            }
        )
    }

    override fun mapToTicket(data: TicketData): Ticket {
        return Ticket(
            data.arrival,
            data.badge,
            data.company,
            data.departure,
            data.handLuggage,
            data.hasTransfer,
            data.hasVisaTransfer,
            data.id,
            data.isExchangable,
            data.isReturnable,
            data.luggage,
            data.price,
            data.providerName
        )
    }

    override fun mapToOffer(data: OfferData): Offer {
        return Offer(
            data.id,
            data.title,
            data.town,
            Price(data.price.value)
        )
    }

    override fun mapToPrice(data: PriceData): Price {
        return Price(data.value)
    }
}
