package com.example.myquotes.Presentation.Screen.HomeScreen


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myquotes.Network.NetworkUIState
import com.example.myquotes.Presentation.Components.AppProgressBar
import com.example.myquotes.Presentation.Components.ToolBarComponent
import com.example.myquotes.Presentation.Screen.HomeScreen.Components.HomeBody
import com.example.myquotes.domain.models.HomeQuotesDC


@Composable
fun HomeScreen(
    homeVM: HomeVM = hiltViewModel(),

    onClick : (id:String) -> Unit

) {

    val state = homeVM.quotesData.collectAsStateWithLifecycle().value

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),

        topBar = {
                ToolBarComponent(title = "Home")
        }



    ) { paddingValues ->

        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
            , contentAlignment = Alignment.Center

        ) {

            when (state){
                is NetworkUIState.LOADING ->{
                    AppProgressBar()

                }
                is NetworkUIState.SUCCESS<HomeQuotesDC> ->{
                    HomeBody (state.data,onClick=onClick)

                }
                else -> Unit
            }


        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable

private fun HomeScreenPreview() {
 HomeScreen{}
}
