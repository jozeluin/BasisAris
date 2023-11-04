package com.example.aplicacionesvarias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.view.marginTop
import com.example.aplicacionesvarias.databinding.ActivityMainBinding
import com.example.aplicacionesvarias.databinding.ActivitySettingsBinding
import com.example.aplicacionesvarias.firstapp.ImcApp
import com.example.aplicacionesvarias.settings.SettingsActivity
import com.example.aplicacionesvarias.superheroapp.SuperHeroListActivity
import com.example.aplicacionesvarias.todoapp.TodoActivity

class MainActivity : AppCompatActivity() {

    private lateinit var bindig:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        bindig=ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindig.root)




        val btnSaludApp=findViewById<Button>(R.id.btnSaludApp)
        val btnTODOApp=findViewById<Button>(R.id.btnTODO)
        val btnSuperHero=findViewById<Button>(R.id.btnSuperHero)

        btnSaludApp.setOnClickListener { navigateToSaludApp()  }
        btnTODOApp.setOnClickListener { navigateToTodoApp() }
        btnSuperHero.setOnClickListener { navigateToSuperHeroApp ()}
        bindig.btnSettings.setOnClickListener {  navigateToSettingsApp()}


    }

    private fun navigateToSettingsApp() {
        val intent=Intent(this,SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSuperHeroApp() {
        val intent=Intent(this,SuperHeroListActivity::class.java)
        startActivity(intent)

    }

    private fun navigateToTodoApp() {
        bindig
        val intent=Intent(this,TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp(){
        val intent=Intent(this,ImcApp::class.java)
        startActivity(intent)
    }
}
/*
val params=view.layoutParams
params.height=pxToDp(stat.toFloat())
view.layoutParams=params
*/
