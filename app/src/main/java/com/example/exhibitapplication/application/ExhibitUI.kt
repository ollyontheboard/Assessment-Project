package com.example.exhibitapplication.application


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.exhibitapplication.model.Exhibit


@Composable
fun ExhibitImages(exhibitImageUrls: String,exhibitItem : Exhibit){
    Card(modifier = Modifier
        .padding(16.dp)
        .height(200.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp

    ) {
        Box(modifier = Modifier
            ) {
            AsyncImage(model = (exhibitImageUrls),
                error = painterResource(id = com.example.exhibitapplication.R.drawable.placeholder),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp),
                contentScale = ContentScale.FillHeight
            )

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentAlignment = Alignment.BottomCenter
                ) {
                Text(text = exhibitItem.title, style = TextStyle( fontSize = 16.sp)
                )
            }
            
        }





    }

}