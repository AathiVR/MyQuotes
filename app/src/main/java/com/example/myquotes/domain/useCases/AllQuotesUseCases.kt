package com.example.myquotes.domain.useCases

import com.example.myquotes.domain.models.AllQuotesDC
import com.example.myquotes.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AllQuotesUseCases @Inject constructor(
    private val quoteRepository: QuoteRepository
) {

 operator fun invoke() = flow {

      quoteRepository.getAllQuotes().let {
          if (it.isSuccessful){
              emit(it.body()?.quotes)
          }
      }
    }
}

