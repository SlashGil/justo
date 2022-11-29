package com.justo.android.justotechnicaltest.data

import com.justo.android.justotechnicaltest.data.user.*

data class User(
    val gender: String = "",
    var name: Name? = null,
    var location: Location? = null,
    var email: String = "",
    var login: LoginInfo? = null,
    var age: Date? = null,
    var registered: Date? = null,
    var phone: String = "",
    var cell: String = "",
    var id: IdInfo? = null,
    var picture: Picture? = null,
    var nationality: String = "MX"
)