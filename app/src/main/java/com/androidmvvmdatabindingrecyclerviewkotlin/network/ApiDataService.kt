package com.androidmvvmdatabindingrecyclerviewkotlin.network


import com.google.gson.JsonArray

import retrofit2.Call
import retrofit2.http.GET

interface ApiDataService {


    @get:GET("users")
    val apiRequestsArray: Call<JsonArray>

}
