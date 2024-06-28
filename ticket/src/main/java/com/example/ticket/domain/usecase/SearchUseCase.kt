package com.example.ticket.domain.usecase

import com.example.ticket.domain.repository.MainRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val repository: MainRepository) {

    suspend fun getSearch() = repository.getSearch()

}