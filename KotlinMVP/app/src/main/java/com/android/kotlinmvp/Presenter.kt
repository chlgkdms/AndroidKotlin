package com.android.kotlinmvp

import android.util.Log
import org.json.JSONObject

class Presenter(val view: MainActivity, val repository: InfoRepository) : Contractor.Presenter{
    override fun initInfo() {
        repository.getInfo(object: InfoDataSource.LoadInfoCallback {
            override fun onInfoLoaded(info: JSONObject) {
                view.showInfo(info)
            }

            override fun onDataNotAvailable() {
                // 아무것도 없음
            }
        })
    }

    override fun setInfo(info: JSONObject) {
        view.showInfo(info)
        Log.d("KBW", info.toString())
    }

    override fun saveInfo(info: JSONObject) {
        repository.saveInfo(info)
    }
}