package com.example.myquotes.data.repositoryImpl

import com.example.myquotes.data.remote.AppInterFace
import com.example.myquotes.domain.models.AllQuotesDC
import com.example.myquotes.domain.repository.QuoteRepository
import retrofit2.Response
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
   private val appInterFace: AppInterFace
):QuoteRepository{
    override suspend fun getAllQuotes(): Response<AllQuotesDC> {
        return appInterFace.getAllQuotes()

    }

    override suspend fun getRandomQuotes(): Response<AllQuotesDC.QuoteDC> {
        return appInterFace.getRandomQuotes()

    }
    override suspend fun getSingleQuote(id:String):Response<AllQuotesDC.QuoteDC>{
        return appInterFace.getSingleQuotes(id = id)
    }

}