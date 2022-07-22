package com.ocode.fetcha.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ocode.fetcha.SingleListApp
import com.ocode.fetcha.screens.SplashScreen
import com.ocode.fetcha.screens.main.SingleListScreen

@Composable
fun FetchNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = FetchScreens.SplashScreen.name){

        composable(FetchScreens.SplashScreen.name){
            SplashScreen(navController = navController)
        }

        composable(FetchScreens.SingleListScreen.name){
            SingleListScreen(navController = navController)
        }
    }
}