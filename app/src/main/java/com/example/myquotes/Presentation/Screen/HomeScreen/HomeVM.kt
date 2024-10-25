package com.example.myquotes.Presentation.Screen.HomeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myquotes.Network.NetworkUIState
import com.example.myquotes.domain.models.AllQuotesDC
import com.example.myquotes.domain.models.HomeQuotesDC
import com.example.myquotes.domain.useCases.AllQuotesUseCases
import com.example.myquotes.domain.useCases.RandomQuotesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject


@HiltViewModel
class HomeVM @Inject constructor(

    private val allQuotesUseCases: AllQuotesUseCases,
    private val randomQuoteUseCases: RandomQuotesUseCases

):ViewModel() {

    var quotesData = MutableStateFlow<NetworkUIState<HomeQuotesDC>>(NetworkUIState.LOADING())
        private set


    init {
        getQuotes()

    }

    private fun getQuotes() {

        quotesData.tryEmit(NetworkUIState.LOADING())
        allQuotesUseCases().combine(randomQuoteUseCases()){ quotesList: List<AllQuotesDC.QuoteDC>?, randomQuote: AllQuotesDC.QuoteDC? ->


            quotesData.tryEmit(NetworkUIState.SUCCESS(HomeQuotesDC(randomQuote=randomQuote, allQuotesList = quotesList)))
        }.launchIn(viewModelScope)

    }


}