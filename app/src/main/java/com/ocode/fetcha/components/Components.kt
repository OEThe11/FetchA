package com.ocode.fetcha.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ocode.fetcha.R


@Composable
fun FetchAppBar(
    elevation: Dp = 0.dp,
) {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        elevation = elevation,
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.fetch),
                contentDescription = "App Icon",
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
fun CircularIndeterminateProgressBar(
    isDisplayed: Boolean
){
    Surface(modifier = Modifier
        .fillMaxSize(),
        color = MaterialTheme.colors.primary) {
        if (isDisplayed){
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(top = 90.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                CircularProgressIndicator(modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                    strokeWidth = 10.dp,
                    color = Color.White
                )
            }
        }

    }

}