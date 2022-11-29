package com.justo.android.justotechnicaltest.data.remote

import com.justo.android.justotechnicaltest.data.RandomUser
import javax.inject.Inject

class RandomUserRemoteDataSource @Inject constructor(private val randomUserService: RandomUserService): BaseDataSource() {
    suspend fun getRandomUser() = getResult<RandomUser> { randomUserService.getRandomUser() }
}