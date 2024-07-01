package com.example.ticket.presentation.ui.fragments.allticketfragment

import androidx.lifecycle.viewModelScope
import com.example.core_utils.Resource
import com.example.core_utils.base.BaseViewModel
import com.example.ticket.domain.model.allteickets.AllTickets
import com.example.ticket.domain.usecase.AllTicketsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllTicketsViewModel @Inject constructor(private val useCase: AllTicketsUseCase):BaseViewModel(){

    private val _allTickets = MutableStateFlow<Resource<AllTickets>>(Resource.Empty())
    val allTickets = _allTickets.asStateFlow()

    fun loadAllTickets(){
        viewModelScope.launch {
            useCase.getAllTickets().collectData(_allTickets)
        }
    }
}