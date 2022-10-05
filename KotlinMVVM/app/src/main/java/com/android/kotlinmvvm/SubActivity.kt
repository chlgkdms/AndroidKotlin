package com.android.kotlinmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.kotlinmvvm.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding
    var text = "서브 페이지"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub)

        binding.subActivity = this
    }
}