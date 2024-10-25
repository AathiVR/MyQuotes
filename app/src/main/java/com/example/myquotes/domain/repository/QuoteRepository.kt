package com.example.myquotes.domain.repository

import com.example.myquotes.domain.models.AllQuotesDC
import retrofit2.Response

interface QuoteRepository {

    suspend fun getAllQuotes():Response<AllQuotesDC>
    suspend fun getRandomQuotes():Response<AllQuotesDC.QuoteDC>
    suspend fun getSingleQuote(id: String): Response<AllQuotesDC.QuoteDC>
}