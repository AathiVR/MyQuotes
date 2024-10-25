package com.example.myquotes.Presentation.Screen.detailScreen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myquotes.Network.NetworkUIState
import com.example.myquotes.domain.models.AllQuotesDC
import com.example.myquotes.domain.useCases.GetSingleQuoteUseCase


import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailVM @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val singleQuoteUseCase: GetSingleQuoteUseCase
):ViewModel(){

    var singleQuoteData = MutableStateFlow<NetworkUIState<AllQuotesDC.QuoteDC?>>(NetworkUIState.LOADING())

      init {
          getSingleQuote(savedStateHandle.get<String>("id")?:"")
      }

    private fun getSingleQuote(id:String){
        singleQuoteData.tryEmit(NetworkUIState.LOADING())
        singleQuoteUseCase(id=id).onEach {
            singleQuoteData.tryEmit(NetworkUIState.SUCCESS(it))
        }.launchIn(viewModelScope)
    }

}