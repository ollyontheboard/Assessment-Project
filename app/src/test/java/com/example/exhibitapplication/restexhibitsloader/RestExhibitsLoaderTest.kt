package com.example.exhibitapplication.restexhibitsloader

import com.example.exhibitapplication.model.Exhibit
import com.example.exhibitapplication.model.ExhibitApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

internal class RestExhibitsLoaderTest {
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun viewmodelCangetExhibitListFromApi()= runTest {
     val viewModel = RestExhibitsLoader()

       viewModel.getExhibits()
        assertEquals(viewModel.exhibitList.isEmpty(), false)
    }

    @Test
    fun viewmodelCangetErrorMessage()= runTest {
        val viewmodel = RestExhibitsLoader()
        viewmodel.getExhibits()
        assertEquals(viewmodel.errorMessage.isEmpty(),false)
    }


}