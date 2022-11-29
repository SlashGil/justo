package com.justo.android.justotechnicaltest.data.user

data class Location(
    private var street: Street? = null,
    private var city: String = "",
    private var state: String = "",
    private var country: String = "",
    private var zipCode: Int = 0,
    private var coordinates: Coordinates? = null,
    private var timezone: Timezone? = null
) {
    override fun toString(): String = "${street.toString()}, $city, $state, ZIP: $zipCode. $country"
}
