package com.example.aplicacionesvarias.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.aplicacionesvarias.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {
    private val categories=listOf(
        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other,

    )
    private val task= mutableListOf(
        Task("PruebaBusiness",TaskCategory.Business),
        Task("PruebaPersonal",TaskCategory.Personal),
        Task("PruebaOther",TaskCategory.Other),

    )


    private lateinit var rvCategories:RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTask:RecyclerView
    private lateinit var taskAdapter:TasksAdapter

    private lateinit var fabAddTask:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
        initListner()
    }

    private fun initListner() {
        fabAddTask.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog(){
        val dialog=Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        dialog.show()
    }

    private fun initComponent() {
        rvCategories=findViewById(R.id.rvCategories)
        rvTask=findViewById(R.id.rvTask)
        fabAddTask=findViewById(R.id.fabAddTask)

    }
    private fun initUI() {
        categoriesAdapter=CategoriesAdapter(categories)
        rvCategories.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter=categoriesAdapter

        taskAdapter=TasksAdapter(task)
        rvTask.layoutManager=LinearLayoutManager(this)
        rvTask.adapter=taskAdapter

    }
}