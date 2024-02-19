package com.example.sharedpreferencestest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.sharedpreferencestest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        sharedPreferences = getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)

        if (sharedPreferences.contains(SHARED_PREF_DATA_KEY)) {
            binding.valueEditText.setText(sharedPreferences.getString(SHARED_PREF_DATA_KEY, ""))
        }

        binding.btSave.setOnClickListener {
            val writeText = binding.valueEditText.text.toString()
            sharedPreferences.edit().apply {
                putString(SHARED_PREF_DATA_KEY, writeText)
            }.apply()
        }

    }

    
    companion object {

        const val SHARED_PREF_KEY = "SHARED_PREF_KEY"
        const val SHARED_PREF_DATA_KEY = "SHARED_PREF_DATA_KEY"

    }

}