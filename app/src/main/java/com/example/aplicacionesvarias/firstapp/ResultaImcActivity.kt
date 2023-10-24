package com.example.aplicacionesvarias.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.aplicacionesvarias.R
import com.example.aplicacionesvarias.firstapp.ImcApp.Companion.IMC_KEY

class ResultaImcActivity : AppCompatActivity() {

    private lateinit var tvResult:TextView
    private lateinit var tvImc:TextView
    private lateinit var tvDescription:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resulta_imc)
        val result=intent.extras?.getDouble(IMC_KEY)?: -1.0
        initComponent()
        initUI(result)
        
        
    }

    private fun initUI(result: Double) {
        when(result){
            in 0.00..18.50->{//Bajo peso
                tvImc
                tvResult
                tvDescription
            }
            in 18.51..24.99->{//Peso Normal
                tvImc
                tvResult
                tvDescription
            }
            in 25.00..29.99->{//Sobre Peso
                tvImc
                tvResult
                tvDescription
            }in 30.00..99.00->{//Obsidad
            tvImc
            tvResult
            tvDescription
            }
            else->{//error
                tvImc.text="error"
                tvResult.text="error"
                tvDescription.text="error"

            }

        }

    }

    private fun initComponent() {
        tvImc = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        
    }
}