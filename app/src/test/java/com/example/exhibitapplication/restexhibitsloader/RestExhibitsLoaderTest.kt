package com.example.exhibitapplication.restexhibitsloader

import com.example.exhibitapplication.model.Exhibit
import com.example.exhibitapplication.model.ExhibitApi
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

internal class RestExhibitsLoaderTest {
    @OptIn(DelicateCoroutinesApi::class)
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }
//with internet connection
    @Test
    fun viewmodelCangetExhibitListFromApi()= runTest {
     val viewModel = RestExhibitsLoader()

       viewModel.getExhibits()
        assertEquals(viewModel.exhibitList.isEmpty(), false)
    }
//without internet coneection
    @Test
    fun viewmodelCangetErrorMessage()= runTest {
        val viewmodel = RestExhibitsLoader()
        viewmodel.getExhibits()
        assertEquals(viewmodel.errorMessage.isEmpty(),false)
    }


}