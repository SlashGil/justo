package com.justo.android.justotechnicaltest.data

data class RandomUser(
    private var results: List<User>,
) {
    fun getResults(): List<User> = results
}