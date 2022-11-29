package com.justo.android.justotechnicaltest.data.remote

import com.justo.android.justotechnicaltest.data.RandomUser
import retrofit2.Response
import retrofit2.http.GET

interface RandomUserService {
    @GET("api/?results=500&noinfo")
    suspend fun getRandomUser() : Response<RandomUser>
}