package com.example.myquotes.domain.models

data class HomeQuotesDC(
    val randomQuote: AllQuotesDC.QuoteDC?=null,
    val allQuotesList :List<AllQuotesDC.QuoteDC>?=null
)



