package com.justo.android.justotechnicaltest.data.repository

import androidx.lifecycle.map
import com.justo.android.justotechnicaltest.data.local.dao.UserDao
import com.justo.android.justotechnicaltest.data.remote.RandomUserRemoteDataSource
import com.justo.android.justotechnicaltest.domain.mappers.toDb
import com.justo.android.justotechnicaltest.domain.mappers.toDomain
import com.justo.android.justotechnicaltest.utils.performGetOperation
import javax.inject.Inject

class RandomUserRepository @Inject constructor(
    private val remoteDataSource: RandomUserRemoteDataSource,
    private val localDataSource: UserDao
) {

    fun getRandomUser() = performGetOperation(
        databaseQuery = {
            localDataSource.getAllUsers()
                .map { listFromDb -> listFromDb.map { userInDb -> userInDb.toDomain() } }
        },
        networkCall = { remoteDataSource.getRandomUser() },
        saveCallResult = { localDataSource.insert(it.getResults().first().toDb()) }
    )

}