package com.example.ticket.data.mapper

import com.example.ticket.data.model.alltikets.AllTicketsData
import com.example.ticket.data.model.alltikets.ArrivalData
import com.example.ticket.data.model.alltikets.DepartureData
import com.example.ticket.data.model.alltikets.HandLuggageData
import com.example.ticket.data.model.alltikets.LuggageData
import com.example.ticket.data.model.alltikets.PriceXData
import com.example.ticket.data.model.alltikets.TicketData
import com.example.ticket.data.model.mainscreen.OfferData
import com.example.ticket.data.model.mainscreen.OfferResponseData
import com.example.ticket.data.model.mainscreen.PriceData
import com.example.ticket.data.model.search.TicketOfferData
import com.example.ticket.data.model.search.TicketOfferResponseData
import com.example.ticket.domain.model.allteickets.AllTickets
import com.example.ticket.domain.model.allteickets.Arrival
import com.example.ticket.domain.model.allteickets.Departure
import com.example.ticket.domain.model.allteickets.HandLuggage
import com.example.ticket.domain.model.allteickets.Luggage
import com.example.ticket.domain.model.allteickets.PriceX
import com.example.ticket.domain.model.allteickets.Ticket
import com.example.ticket.domain.model.mainscreen.Offer
import com.example.ticket.domain.model.mainscreen.OfferResponse
import com.example.ticket.domain.model.mainscreen.Price
import com.example.ticket.domain.model.search.TicketOffer
import com.example.ticket.domain.model.search.TicketOfferResponse


fun OfferResponseData.toOfferResponse() = OfferResponse(
    offers.map { it.toOffer() }
)

fun TicketOfferResponseData.toTicket() = TicketOfferResponse(
    tickets_offers.map { it.toTicket() }
)

fun AllTicketsData.toAllTickets() = AllTickets(
    tickets.map {  it.toAllTickets() }
)

fun ArrivalData.toArrival() = Arrival(
    airport, date, town
)

fun DepartureData.toDepartu() = Departure(
    airport, date, town
)

fun HandLuggageData.toHandluggage() = HandLuggage(
    has_hand_luggage, size
)

fun LuggageData.toLuggage() = Luggage(
    has_luggage, price?.toPriceX()
)

fun TicketData.toAllTickets() = Ticket(
    arrival.toArrival(), badge, company, departure.toDepartu(),
    hand_luggage.toHandluggage(), has_transfer, has_visa_transfer, id, is_exchangable, is_returnable,
    luggage.toLuggage(), price.toPriceX(), provider_name
)


fun TicketOfferData.toTicket() = TicketOffer(
    id, title, time_range, price.toPrice()
)

fun OfferData.toOffer() = Offer(
    id, title, town, price.toPrice()
)


fun PriceData.toPrice() = Price(
    value
)

fun PriceXData.toPriceX() = PriceX(
    value
)