package com.example.exhibitapplication.restexhibitsloader


import com.example.exhibitapplication.Constants
import com.example.exhibitapplication.model.ExhibitsLoader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


internal class ExhibitsLoaderTest {
  private val retrofit = Retrofit.Builder()
    @Before
    fun setUp(){
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        retrofit
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(Constants.BASE_URL)


    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun canGetExhibitFromApi()= runTest{
        val exhibitsLoader: ExhibitsLoader by lazy{
          retrofit.build()
              .create(ExhibitsLoader::class.java)
        }

         val exhibitList = exhibitsLoader.getExhibitList()

        assertEquals(exhibitList.isEmpty(),false)

    }


}