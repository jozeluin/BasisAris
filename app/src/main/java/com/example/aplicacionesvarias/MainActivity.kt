package com.example.aplicacionesvarias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.aplicacionesvarias.firstapp.ImcApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSaludApp=findViewById<Button>(R.id.btnSaludApp)
        btnSaludApp.setOnClickListener { navigateToSaludApp()  }
    }

    private fun navigateToSaludApp(){
        val intent=Intent(this,ImcApp::class.java)
        startActivity(intent)
    }
}

