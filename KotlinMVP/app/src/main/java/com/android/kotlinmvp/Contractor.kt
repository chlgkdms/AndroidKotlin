package com.android.kotlinmvp

import org.json.JSONObject

interface Contractor {
    interface View {
        fun showInfo(info: JSONObject)
    }

    interface Presenter {
        fun initInfo()
        fun setInfo(info: JSONObject)
        fun saveInfo(info: JSONObject)
    }
}