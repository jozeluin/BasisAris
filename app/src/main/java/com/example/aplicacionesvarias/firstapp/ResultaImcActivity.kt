package com.example.aplicacionesvarias.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplicacionesvarias.R
import com.example.aplicacionesvarias.firstapp.ImcApp.Companion.IMC_KEY

class ResultaImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resulta_imc)
        val result=intent.extras?.getDouble(IMC_KEY)?: -1.0
    }
}