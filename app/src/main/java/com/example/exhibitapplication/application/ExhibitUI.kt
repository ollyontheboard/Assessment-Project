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
import coil.compose.AsyncImage
import com.example.exhibitapplication.Constants
import com.example.exhibitapplication.Dimens
import com.example.exhibitapplication.model.Exhibit





@Composable
fun ExhibitImages(exhibitImageUrls: String,exhibitItem : Exhibit){
    Card(modifier = Modifier
        .padding(Dimens.allPadding)
        .height(Dimens.cardSize),
        shape = RoundedCornerShape(Dimens.cornerSize),
        elevation = Dimens.smallElevation,


    ) {
        Box(modifier = Modifier
            .wrapContentSize()
            .absolutePadding(top = Dimens.topPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(text = exhibitItem.title, style = TextStyle( fontSize = Dimens.fontSize),)

            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                AsyncImage(model = (exhibitImageUrls),
                    error = painterResource(id = com.example.exhibitapplication.R.drawable.placeholder),
                    contentDescription = exhibitItem.title,
                    modifier = Modifier
                        .size(Dimens.imageSize),
                    contentScale = ContentScale.FillHeight
                )
            } } }

}

@Composable fun ErrorMessage(){

    Box(modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.Center
    ) {
        Text(text = Constants.ERROR_TEXT)
    }

}