package com.justo.android.justotechnicaltest.domain.mappers

import com.google.gson.Gson
import com.justo.android.justotechnicaltest.data.User
import com.justo.android.justotechnicaltest.domain.entities.UserEntity


fun User.toDb(): UserEntity {
    val json = Gson().toJson(this)
    return UserEntity(user = json)
}

fun UserEntity.toDomain(): User {
    val gson = Gson()
    return gson.fromJson(this.user, User::class.java)
}