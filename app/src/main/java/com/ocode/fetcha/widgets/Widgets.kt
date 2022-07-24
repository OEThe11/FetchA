package com.ocode.fetcha.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ocode.fetcha.database.FetchItemEntity


@Preview
@Composable
fun FetchCard(fetchItem: FetchItemEntity = FetchItemEntity(4, 56, "ty")) {
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