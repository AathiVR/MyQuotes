package com.example.myquotes.Presentation.NavControl

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myquotes.Presentation.Screen.HomeScreen.HomeScreen
import com.example.myquotes.Presentation.Screen.detailScreen.DetailScreen



@Composable
fun AppNavController() {


    val navController = rememberNavController()

      NavHost(navController = navController, startDestination = ScreenName.HOME_SCREEN) {

          composable(route = ScreenName.HOME_SCREEN) {
              HomeScreen { id ->
                  navController.navigate(ScreenName.DETAIL_SCREEN + "/$id")
              }
          }

          composable(route = ScreenName.DETAIL_SCREEN + "/{id}", arguments = listOf(
              navArgument(name = "id") {
                  type = NavType.StringType
              }
          )) {
              DetailScreen {
                  navController.popBackStack()
              }
          }

      }
}


