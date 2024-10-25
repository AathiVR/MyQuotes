package com.example.myquotes.domain.useCases

import com.example.myquotes.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RandomQuotesUseCases @Inject constructor(
    private val quoteRepository: QuoteRepository
)  {


 operator fun invoke() = flow {

        quoteRepository.getRandomQuotes().let {
            if (it.isSuccessful){
                emit(it.body())
            }
        }
    }

}