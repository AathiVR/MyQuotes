package com.example.myquotes.Presentation.Screen.HomeScreen.Components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myquotes.domain.models.AllQuotesDC

@Composable
fun RandomQuotesItem(quoteDC: AllQuotesDC.QuoteDC) {

    QuotesItem(
        quoteDC=quoteDC,
        color = Color.Blue,
        textColor = Color.LightGray
    )

}

@Preview(showBackground = true)
@Composable
private fun  RandomQuotesItemPreview () {

    RandomQuotesItem(AllQuotesDC.QuoteDC())

}