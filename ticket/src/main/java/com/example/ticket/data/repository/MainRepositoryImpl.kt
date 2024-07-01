package com.example.ticket.data.repository

import com.example.core_utils.base.BaseRepository
import com.example.ticket.data.mapper.DomainMapper
import com.example.ticket.data.remote.MainApiService
import com.example.ticket.domain.model.allteickets.AllTickets
import com.example.ticket.domain.model.mainscreen.OfferResponse
import com.example.ticket.domain.model.search.TicketOfferResponse
import com.example.ticket.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val apiService: MainApiService,
    private val domainMapper: DomainMapper 
) : MainRepository, BaseRepository() {

    override suspend fun getMainScreen() = doRequest {
        val response = apiService.getMainScreen()
        domainMapper.mapToOfferResponse(response)
    }

    override suspend fun getSearch() = doRequest {
        val response = apiService.getSearch()
        domainMapper.mapToTicketOfferResponse(response)
    }

    override suspend fun getAllTickets() = doRequest {
        val response = apiService.getAllTickets()
        domainMapper.mapToAllTickets(response)
    }
}
