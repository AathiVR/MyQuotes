package com.example.myquotes.data.remote

import com.example.myquotes.Network.ALL_QUOTES
import com.example.myquotes.Network.GET_SINGLE_QUOTE
import com.example.myquotes.Network.RANDOM_QUOTE
import com.example.myquotes.domain.models.AllQuotesDC
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AppInterFace {

    @GET(ALL_QUOTES)
    suspend fun getAllQuotes():Response<AllQuotesDC>


    @GET(RANDOM_QUOTE)
    suspend fun getRandomQuotes():Response<AllQuotesDC.QuoteDC>

    @GET(GET_SINGLE_QUOTE)
    suspend fun getSingleQuotes(
        @Path("id") id: String
    ): Response<AllQuotesDC.QuoteDC>
}