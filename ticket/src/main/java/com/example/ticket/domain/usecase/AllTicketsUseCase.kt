package com.example.ticket.domain.usecase

import com.example.ticket.domain.repository.MainRepository
import javax.inject.Inject

class AllTicketsUseCase @Inject constructor(private val repository: MainRepository) {

    suspend fun getAllTickets() = repository.getAllTickets()
}