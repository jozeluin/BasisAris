package com.example.aplicacionesvarias.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplicacionesvarias.R

class ResultaImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resulta_imc)
        val result=intent.extras?.getDouble("IMC_RESULT")?: -1.0
    }
}