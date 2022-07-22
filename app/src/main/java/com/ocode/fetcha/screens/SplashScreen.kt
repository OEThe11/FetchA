package com.ocode.fetcha.screens

import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ocode.fetcha.R
import com.ocode.fetcha.navigation.FetchScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){

    val scale =  remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue = 0.9f,
                            animationSpec = tween(
                                durationMillis = 800,
                                easing = {
                                    OvershootInterpolator(8f)
                                        .getInterpolation(it)
                                }))

        delay(2000L)
        navController.navigate(FetchScreens.SingleListScreen.name)
    })


    Surface(
        modifier = Modifier
            .padding(15.dp)
            .size(330.dp)
            .scale(scale.value),
        shape = RectangleShape,
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier.padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(painter = painterResource(id = R.drawable.fetch),
                contentDescription = "App Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(275.dp))
        }
    }

}