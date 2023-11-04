package com.example.aplicacionesvarias.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplicacionesvarias.R
import com.example.aplicacionesvarias.databinding.ActivityMainBinding
import com.example.aplicacionesvarias.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var bindig: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig=ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(bindig.root)
    }
}