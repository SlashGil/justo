package com.justo.android.justotechnicaltest.data.user

data class Street(
    private var number: Int = 0,
    private var name: String = ""
) {
    override fun toString(): String = "$name $number"
}
