package com.ocode.fetcha.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ocode.fetcha.R
import com.ocode.fetcha.components.CircularIndeterminateProgressBar
import com.ocode.fetcha.components.FetchAppBar
import com.ocode.fetcha.database.FetchItemEntity
import com.ocode.fetcha.models.GetFetchResponseItem
import com.ocode.fetcha.widgets.FetchCard


@Composable
fun SingleListScreen(navController: NavController, viewModel: FetchViewModel = hiltViewModel()) {

   val fetchItems by viewModel.fetchInfoResults.observeAsState()

   val loading = viewModel.loading.value

   Scaffold(bottomBar = {
      FetchAppBar(elevation = 2.dp)

   }) {
      Surface(
         modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 55.dp),
         color = MaterialTheme.colors.primary) {
         fetchItems?.let {
               it1 ->
            if (loading){
               CircularIndeterminateProgressBar(isDisplayed = true)
            }else{
               MainList(list = it1)
            }
             }
      }

   }
}

@Composable
fun MainList(list: List<FetchItemEntity>){
   LazyColumn{
      items(list){ item ->
         FetchCard(fetchItem = item)
      }
   }
}








