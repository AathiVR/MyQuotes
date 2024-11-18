package com.example.myquotes.Presentation.Screen.detailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myquotes.Network.NetworkUIState
import com.example.myquotes.Presentation.Components.AppProgressBar
import com.example.myquotes.Presentation.Components.ToolBarComponent
import com.example.myquotes.Presentation.Screen.detailScreen.Components.DetailQuotes

@Composable
fun DetailScreen(
    detailVM: DetailVM = hiltViewModel(),
    onBackPress : () -> Unit
) {
    val state = detailVM.singleQuoteData.collectAsStateWithLifecycle().value

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            ToolBarComponent(
                showBackButton = true,
                title = "Details",
                onBackPress = onBackPress


            )
        }

    ) { paddingValue ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
                .background(Color.LightGray)
                , contentAlignment = Alignment.Center

        ) {
            when(state){
               is NetworkUIState.LOADING -> {
                    AppProgressBar()
                }

                is NetworkUIState.SUCCESS -> {
                    DetailQuotes(data = state.data)
                }
                else -> Unit
            }



        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreenPreview() {

    DetailScreen{}

}