package com.example.myquotes.Presentation.Screen.HomeScreen.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myquotes.domain.models.HomeQuotesDC

@Composable
fun HomeBody(
    homeQuotesDC: HomeQuotesDC,

    onClick: (id:String) -> Unit


) {

    LazyColumn(

        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)

    ) {
        homeQuotesDC.randomQuote?.let {
            item {

                HeadingTitle(title = "Random Quotes")
                RandomQuotesItem(homeQuotesDC.randomQuote)
            }
        }




     item {
         HeadingTitle(title = "Quotes")
     }
       items(homeQuotesDC.allQuotesList ?: emptyList()){
           QuotesItem(
               quoteDC = it,
               modifier = Modifier.clickable {
                   onClick(it.id.toString())
               }
               )
       }


    }

}

@Preview(showBackground = true)
@Composable
private fun HomeBodyPreview(modifier: Modifier = Modifier) {
    HomeBody(HomeQuotesDC()){}

}