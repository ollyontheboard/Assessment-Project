package com.example.exhibitapplication.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.exhibitapplication.model.Exhibit

@Composable
fun ExhibitItem(exhibit: Exhibit){
    Card(modifier = Modifier.fillMaxWidth()) {
       Text(text = exhibit.title)

         } }
@Composable
fun ExhibitImages(exhibitImageUrls: String){
    Image(painter = rememberAsyncImagePainter(exhibitImageUrls),
                contentDescription = null,
                modifier = Modifier.size(200.dp))
}