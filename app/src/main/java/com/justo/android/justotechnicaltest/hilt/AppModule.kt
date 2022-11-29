package com.justo.android.justotechnicaltest.hilt

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.justo.android.justotechnicaltest.api.Constants
import com.justo.android.justotechnicaltest.data.local.UserDatabase
import com.justo.android.justotechnicaltest.data.local.dao.UserDao
import com.justo.android.justotechnicaltest.data.remote.RandomUserRemoteDataSource
import com.justo.android.justotechnicaltest.data.remote.RandomUserService
import com.justo.android.justotechnicaltest.data.repository.RandomUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.DEFAULT_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideRandomUserService(retrofit: Retrofit): RandomUserService =
        retrofit.create(RandomUserService::class.java)

    @Singleton
    @Provides
    fun provideRandomUserRemoteDataSource(randomUserService: RandomUserService) =
        RandomUserRemoteDataSource(randomUserService)


    @Singleton
    @Provides
    fun provideUserDao(db: UserDatabase) = db.userDao()

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: RandomUserRemoteDataSource,
        localDataSource: UserDao
    ) =
        RandomUserRepository(remoteDataSource, localDataSource)

    @Provides
    @Singleton
    fun databaseProvider(@ApplicationContext app: Context) = Room.databaseBuilder(
        app,
        UserDatabase::class.java,
        "user-db"
    ).build()

}