package com.justo.android.justotechnicaltest.data.user

data class IdInfo(
    private var name: String = "",
    private var value: String = ""
) {
    override fun toString(): String = "Name of ID: $name \n ID: $value"
}
