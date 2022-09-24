package com.android.kotlinmvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.kotlinmvc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        user = User()

        binding.btMainLogin.setOnClickListener {
            val isLoginSuccessful = user.login(
                binding.etMainId.text.toString(),
                binding.etMainPassword.text.toString(),
            )

            if (isLoginSuccessful)
                Toast.makeText(this@MainActivity, "${user.userName} Login Successful", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this@MainActivity, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}