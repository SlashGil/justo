package com.justo.android.justotechnicaltest.data.user

data class Name(
    private var title: String = "",
    private var first: String = "",
    private var last: String = ""
) {
    override fun toString(): String = "$title. $first $last"
}
