package com.android.kotlinmvc

data class User(
    var userName: String? = null,
    var password: String? = null
) {
    // 비즈니스 로직
    fun login(userName: String?, password: String?): Boolean {
        if (userName == secretName && password == secretWord) {
            this.userName = userName
            this.password = password
            return true
        }
        return false
    }

    companion object {
        const val secretName = "user"
        const val secretWord = "1234"
    }
}
