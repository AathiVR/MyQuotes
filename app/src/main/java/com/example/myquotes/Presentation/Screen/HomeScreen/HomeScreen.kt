package com.example.myquotes.Presentation.Screen.HomeScreen


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myquotes.Network.NetworkUIState
import com.example.myquotes.Presentation.Components.AppProgressBar
import com.example.myquotes.Presentation.Components.ToolBarComponent
import com.example.myquotes.Presentation.Screen.HomeScreen.Components.HomeBody
import com.example.myquotes.domain.models.HomeQuotesDC


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeVM: HomeVM = hiltViewModel(),

    onClick: (id: String) -> Unit

) {

    val state = homeVM.quotesData.collectAsStateWithLifecycle().value

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),


        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(top = 10.dp).alpha(0.8f),


                title = {
                    Text(
                        text = "Home",
                        modifier = Modifier
                            .padding(start = 90.dp),
                             fontSize = 30.sp,
                           fontStyle = FontStyle.Normal

                    )


                }, navigationIcon = {

                    Icon(imageVector = Icons.Filled.Home, contentDescription = "null", modifier = Modifier.padding(start = 10.dp))

                }, colors = TopAppBarDefaults.topAppBarColors(Color.Gray.copy(0.2f))
            )


        }


    ) { paddingValues ->

        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(), contentAlignment = Alignment.Center

        ) {

            when (state) {
                is NetworkUIState.LOADING -> {
                    AppProgressBar()

                }

                is NetworkUIState.SUCCESS<HomeQuotesDC> -> {
                    HomeBody(state.data, onClick = onClick)

                }

                else -> Unit
            }


        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable

private fun HomeScreenPreview() {
    HomeScreen {}
}
