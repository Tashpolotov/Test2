package com.example.ticket.data.model.alltikets

import com.example.ticket.data.model.alltikets.ArrivalData
import com.example.ticket.data.model.alltikets.DepartureData
import com.example.ticket.data.model.alltikets.HandLuggageData
import com.example.ticket.data.model.alltikets.LuggageData
import com.example.ticket.data.model.alltikets.PriceXData

data class TicketData(
    val arrival: ArrivalData,
    val badge: String,
    val company: String,
    val departure: DepartureData,
    val hand_luggage: HandLuggageData,
    val has_transfer: Boolean,
    val has_visa_transfer: Boolean,
    val id: Int,
    val is_exchangable: Boolean,
    val is_returnable: Boolean,
    val luggage: LuggageData,
    val price: PriceXData,
    val provider_name: String
)