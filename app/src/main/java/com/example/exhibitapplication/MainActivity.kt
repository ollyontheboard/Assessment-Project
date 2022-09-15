package com.example.exhibitapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.exhibitapplication.application.ExhibitImages
import com.example.exhibitapplication.application.ExhibitItem
import com.example.exhibitapplication.model.Exhibit
import com.example.exhibitapplication.restexhibitsloader.RestExhibitsLoader
import com.example.exhibitapplication.ui.theme.ExhibitApplicationTheme

class MainActivity : ComponentActivity() {
    private val viewModel : RestExhibitsLoader by lazy {
        ViewModelProvider(this)[RestExhibitsLoader::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExhibitApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ExhibitList(exhibitList = viewModel.exhibitList)


                }
            }
        }
    }
}
@Composable
fun ExhibitList(exhibitList: List<Exhibit>){
    LazyColumn{
        itemsIndexed(items = exhibitList){itemindex, item ->
            ExhibitItem(exhibit = item)
            LazyRow{
                itemsIndexed(items = exhibitList[itemindex].images){index, item ->  
                    ExhibitImages(exhibitImageUrls = item)
                }
            }
            
        }
    }
    }
    




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExhibitApplicationTheme {
        ExhibitList(exhibitList = listOf(
            Exhibit("EX one", listOf("Image One", "Image Two")),
            Exhibit("EX two", listOf("Image One", "Image Two")),
            Exhibit("EX three", listOf("Image One", "Image Two")),

        ))

    }
}