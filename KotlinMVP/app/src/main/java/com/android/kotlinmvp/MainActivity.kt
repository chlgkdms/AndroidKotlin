package com.android.kotlinmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.kotlinmvp.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity(), Contractor.View    {

    private lateinit var presenter: Presenter
    private lateinit var repository: InfoRepository
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = InfoRepository(this)
        presenter = Presenter(this@MainActivity, repository)

        presenter.initInfo()
        initButtonListener()
    }

    override fun showInfo(info: JSONObject) {
        binding.outputName.text = info.getString("name")
        binding.outputEmail.text = info.getString("email")

        Log.d("KBW", info.getString("name"))
        Log.d("KBW", info.getString("email"))
    }

    fun initButtonListener() {
        binding.btnSave.setOnClickListener {
            Log.d("KBW", "hi")

            var info = JSONObject()
            info.put("name", binding.editName.text.toString())
            info.put("email", binding.editEmail.text.toString())

            binding.editName.text.clear()
            binding.editEmail.text.clear()

            presenter.setInfo(info)
            presenter.saveInfo(info)
        }
    }
}