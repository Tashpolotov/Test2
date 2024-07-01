package com.example.ticket.data.model.alltikets

import com.example.ticket.data.model.alltikets.ArrivalData
import com.example.ticket.data.model.alltikets.DepartureData
import com.example.ticket.data.model.alltikets.HandLuggageData
import com.example.ticket.data.model.alltikets.LuggageData
import com.example.ticket.data.model.alltikets.PriceXData
import com.example.ticket.domain.model.allteickets.Arrival
import com.example.ticket.domain.model.allteickets.Departure
import com.example.ticket.domain.model.allteickets.HandLuggage
import com.example.ticket.domain.model.allteickets.Luggage
import com.example.ticket.domain.model.allteickets.PriceX
import com.google.gson.annotations.SerializedName

data class TicketData(
    val arrival: Arrival,
    val badge: String? = null,
    val company: String,
    val departure: Departure,
    @SerializedName("hand_luggage")
    val handLuggage: HandLuggage,
    @SerializedName("has_transfer")
    val hasTransfer: Boolean,
    @SerializedName("has_visa_transfer")
    val hasVisaTransfer: Boolean,
    val id: Int,
    @SerializedName("is_exchangable")
    val isExchangable: Boolean,
    @SerializedName("is_returnable")
    val isReturnable: Boolean,
    val luggage: Luggage,
    val price: PriceX,
    @SerializedName("provider_name")
    val providerName: String
)