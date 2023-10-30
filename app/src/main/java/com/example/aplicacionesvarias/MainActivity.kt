package com.example.aplicacionesvarias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.aplicacionesvarias.firstapp.ImcApp
import com.example.aplicacionesvarias.todoapp.TodoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var text=getString(R.string.todo_dialog_category_Personal)


        val btnSaludApp=findViewById<Button>(R.id.btnSaludApp)
        val btnTODOApp=findViewById<Button>(R.id.btnTODO)

        btnSaludApp.setOnClickListener { navigateToSaludApp()  }
        btnTODOApp.setOnClickListener { navigateToTodoApp() }
    }

    private fun navigateToTodoApp() {
        val intent=Intent(this,TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp(){
        val intent=Intent(this,ImcApp::class.java)
        startActivity(intent)
    }
}

