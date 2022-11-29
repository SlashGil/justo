package com.justo.android.justotechnicaltest.data.user

data class LoginInfo(
    private var uuid: String = "",
    private var username: String = "",
    private var password: String = "",
    private var salt: String = "",
    private var md5: String = "",
    private var sha1: String = "",
    private var sha256: String = ""
) {
    override fun toString(): String = "Username: $username \n  Password: $password \n Salt: $salt \n MD5: $md5 \n SHA1: $sha1 \n SHA256: $sha256"
}
