package com.example.exhibitapplication.model

import com.example.exhibitapplication.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ExhibitsLoader {
    @GET("/Reyst/exhibit_db/list")
    suspend fun getExhibitList(): List<Exhibit>
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Constants.BASE_URL)
    .build()

object ExhibitApi{
    val exhibitsLoader: ExhibitsLoader by lazy{
        retrofit.create(ExhibitsLoader::class.java)
    }

}