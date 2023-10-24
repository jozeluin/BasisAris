package com.example.aplicacionesvarias.firstapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.aplicacionesvarias.R
import com.example.aplicacionesvarias.firstapp.ImcApp.Companion.IMC_KEY

class ResultaImcActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvImc: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnRecalculate:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resulta_imc)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponent()
        initUI(result)
        initListener()


    }

    private fun initListener() {
        btnRecalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvImc.text = result.toString()
        when (result) {
            in 0.00..18.50 -> {//Bajo peso

                tvResult.text = getString(R.string.title_bajo_peso)
                tvDescription.text = getString(R.string.descripcion_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_bajo))
            }

            in 18.51..24.99 -> {//Peso Normal

                tvResult.text  = getString(R.string.title_peso_normal)
                tvDescription.text = getString(R.string.descripcion_peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_normal))
            }

            in 25.00..29.99 -> {//Sobre Peso

                tvResult.text  = getString(R.string.title_sobrepeso)
                tvDescription.text = getString(R.string.descripcion_sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_sobrepeso))
            }

            in 30.00..99.00 -> {//Obsidad

                tvResult.text  = getString(R.string.title_obesidad)
                tvDescription.text = getString(R.string.descripcion_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.obesidad))
            }

            else -> {//error
                tvImc.text = "error"
                tvResult.text = "error"
                tvDescription.text = "error"

            }

        }

    }

    private fun initComponent() {
        btnRecalculate=findViewById(R.id.btnRecalculate)
        tvImc = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)

    }
}