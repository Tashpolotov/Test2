package com.example.ticket.data.repository

import com.example.core_utils.base.BaseRepository
import com.example.ticket.data.mapper.toAllTickets
import com.example.ticket.data.mapper.toOfferResponse
import com.example.ticket.data.mapper.toTicket
import com.example.ticket.data.remote.MainApiService
import com.example.ticket.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val apiService: MainApiService):
    MainRepository, BaseRepository() {
    override suspend fun getMainScreen() = doRequest {
        apiService.getMainScreen().toOfferResponse()
    }

    override suspend fun getSearch() = doRequest {
        apiService.getSearch().toTicket()
    }

    override suspend fun getAllTickets() = doRequest {
        apiService.getAllTickets().toAllTickets()
    }
}