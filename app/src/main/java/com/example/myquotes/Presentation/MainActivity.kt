package com.example.myquotes.Presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myquotes.Presentation.NavControl.AppNavController
import com.example.myquotes.Presentation.Screen.HomeScreen.HomeScreen
import com.example.myquotes.Presentation.Screen.detailScreen.DetailScreen
import com.example.myquotes.Presentation.theme.MyQuotesTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyQuotesTheme {
                AppNavController()
            }
        }
    }
}
