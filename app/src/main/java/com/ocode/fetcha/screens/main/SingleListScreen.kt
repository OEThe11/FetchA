package com.ocode.fetcha.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ocode.fetcha.R
import com.ocode.fetcha.models.GetFetchResponseItem


@Composable
fun SingleListScreen(navController: NavController) {
   Scaffold(bottomBar = {
      FetchAppBar(elevation = 2.dp)

   }) {
      Surface(
         modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 55.dp),
         color = MaterialTheme.colors.primary) {
         MainList()
      }

   }
}

@Composable
fun MainList(modifier: Modifier = Modifier) {

   val dummyList  = listOf(
      GetFetchResponseItem(1, 22, "hehehehehe"),
      GetFetchResponseItem(2, 455, "hdbgfe"),
      GetFetchResponseItem(3, 262, "hccbtdj"),
      GetFetchResponseItem(4, 69, "ntnjrj"),
      GetFetchResponseItem(5, 40, "ndnry"),
      GetFetchResponseItem(6, 90, "brbrgnhy"),
      GetFetchResponseItem(7, 50, "hennnnn"),
      GetFetchResponseItem(8, 21, "herhrr"),
      GetFetchResponseItem(9, 220, "hgerhr"),
      GetFetchResponseItem(10, 99, "Im really Him")
   )

   TrialList(list = dummyList)

}

@Composable
fun TrialList(list: List<GetFetchResponseItem>){
   LazyColumn{
      items(list){ item ->
         FetchCard(fetchItem = item)
      }
   }
}


@Preview
@Composable
fun FetchCard(fetchItem: GetFetchResponseItem = GetFetchResponseItem(2, 4, "AAA")) {
   Card(modifier = Modifier
      .fillMaxWidth()
      .height(110.dp)
      .padding(16.dp),
   shape = RoundedCornerShape(size = 20.dp),
   backgroundColor = MaterialTheme.colors.primaryVariant,
   elevation = 10.dp) {
      Row(horizontalArrangement = Arrangement.SpaceBetween) {
         Column(modifier = Modifier.padding(start = 16.dp, top = 10.dp,
            bottom = 10.dp, end = 10.dp)) {
            Text(text = "ListId:",
            style = MaterialTheme.typography.h6,
            fontStyle = FontStyle.Italic
            )
            Text(text = "${fetchItem.listId}",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold)
         }

         Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp,
            bottom = 10.dp, end = 16.dp)) {
            Text(text = "Name:",
               modifier = Modifier.align(Alignment.End),
               style = MaterialTheme.typography.h6,
               fontStyle = FontStyle.Italic)
            Text(text = fetchItem.name,
               style = MaterialTheme.typography.h5,
               fontWeight = FontWeight.Bold)
         }
      }

   }
}


//Create Components File for this Composable
@Composable
fun FetchAppBar(
   elevation: Dp = 0.dp,
) {
   BottomAppBar(
      backgroundColor = MaterialTheme.colors.primaryVariant,
      elevation = elevation,
      ){
      Row(modifier = Modifier.fillMaxSize(),
         horizontalArrangement = Arrangement.Center) {
         Image(painter = painterResource(id = R.drawable.fetch),
            contentDescription = "App Icon",
            contentScale = ContentScale.Fit)
      }
   }


}
