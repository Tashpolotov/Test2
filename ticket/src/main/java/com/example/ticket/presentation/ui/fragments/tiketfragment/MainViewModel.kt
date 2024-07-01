package com.example.ticket.presentation.ui.fragments.tiketfragment

import android.text.InputFilter
import androidx.lifecycle.viewModelScope
import com.example.core_utils.Resource
import com.example.core_utils.base.BaseViewModel
import com.example.ticket.domain.model.mainscreen.OfferResponse
import com.example.ticket.domain.usecase.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: MainUseCase) : BaseViewModel() {

    private val _mainScreen = MutableStateFlow<Resource<OfferResponse>>(Resource.Empty())
    val mainScreen = _mainScreen.asStateFlow()

    private val _cyrillicFilter = MutableStateFlow<InputFilter?>(null)
    val cyrillicFilter = _cyrillicFilter.asStateFlow()

    init {
        _cyrillicFilter.value = InputFilter { source, _, _, _, _, _ ->
            val regex = Regex("[а-яА-ЯёЁ\\s]+")
            if (source.toString().matches(regex)) {
                null
            } else {
                ""
            }
        }
    }

    fun loadMainScreen() {
        viewModelScope.launch {
            useCase.getMainScreen().collectData(_mainScreen)
        }
    }
}