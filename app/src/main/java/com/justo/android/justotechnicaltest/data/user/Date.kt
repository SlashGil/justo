package com.justo.android.justotechnicaltest.data.user

import java.util.Date

data class Date(
    private var date: java.util.Date? = null,
    private var age: Int = 0
) {
    fun getDate(): Date? = date
}
