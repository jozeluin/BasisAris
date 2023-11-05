package com.example.aplicacionesvarias

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicacionesvarias.databinding.ActivityMainBinding
import com.example.aplicacionesvarias.firstapp.ImcApp
import com.example.aplicacionesvarias.settings.SettingsActivity
import com.example.aplicacionesvarias.superheroapp.SuperHeroListActivity
import com.example.aplicacionesvarias.todoapp.TodoActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
       // setContentView(R.layout.activity_main)
        setContentView(binding.root)

/*
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnTODOApp = findViewById<Button>(R.id.btnTODO)
        val btnSuperHero = findViewById<Button>(R.id.btnSuperHero)
        val btnSettings = findViewById<Button>(R.id.btnSettings)


        btnSaludApp.setOnClickListener { navigateToSaludApp() }
        btnTODOApp.setOnClickListener { navigateToTodoApp() }
        btnSuperHero.setOnClickListener { navigateToSuperHeroApp() }
        btnSettings.setOnClickListener { navigateToSettingsApp() }
*/
        initUI()
    }
    private fun initUI(){
        binding.btnSaludApp.setOnClickListener { navigateToSaludApp() }

        binding.btnTODO.setOnClickListener { navigateToTodoApp() }
        binding.btnSuperHero.setOnClickListener { navigateToSuperHeroApp() }
        binding.btnSettings.setOnClickListener { navigateToSettingsApp() }
    }

    private fun navigateToSettingsApp() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSuperHeroApp() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)

    }

    private fun navigateToTodoApp() {
        //bindig
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp() {
        val intent = Intent(this, ImcApp::class.java)
        startActivity(intent)
    }
}
/*
val params=view.layoutParams
params.height=pxToDp(stat.toFloat())
view.layoutParams=params
*/
