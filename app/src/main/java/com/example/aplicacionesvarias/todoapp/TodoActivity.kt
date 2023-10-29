package com.example.aplicacionesvarias.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.aplicacionesvarias.R
import com.example.aplicacionesvarias.todoapp.TaskCategory.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.FieldPosition

class TodoActivity : AppCompatActivity() {
    private val categories=listOf(
        Business,
        Personal,
        Other,

    )
    private val tasks= mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaPersonal", Personal),
        Task("PruebaOther", Other),

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

        val btnAddTas: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTas.setOnClickListener {
            val currentask=etTask.text.toString()
            if(currentask.isNotEmpty()){
                val selectedId = rgCategories.checkedRadioButtonId
                val seletedRadioButton:RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory:TaskCategory= when(seletedRadioButton.text){

                    getString(R.string.todo_dialog_category_Bussines)-> Business
                    getString(R.string.todo_dialog_category_Personal) -> Personal

                    else-> Other

                }
                tasks.add(Task(currentask,currentCategory))
                updateTasks()
                dialog.hide()
            }


        }



        dialog.show()
    }

    private fun initComponent() {
        rvCategories=findViewById(R.id.rvCategories)
        rvTask=findViewById(R.id.rvTask)
        fabAddTask=findViewById(R.id.fabAddTask)

    }
    private fun initUI() {
        categoriesAdapter=CategoriesAdapter(categories){updateCategories(it)}
        rvCategories.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter=categoriesAdapter

        taskAdapter=TasksAdapter(tasks){onItemSelected(it)}
        rvTask.layoutManager=LinearLayoutManager(this)
        rvTask.adapter=taskAdapter

    }

    private fun updateCategories(position: Int){
        categories[position].isSelected=!categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()

    }

    private fun onItemSelected(position: Int){
        tasks[position].isSelected=!tasks[position].isSelected
        updateTasks()
    }


    /**
     * Avisa al adaptador que hay nuevos items
     *
     */
    private fun updateTasks(){
        val selectedCategories:List<TaskCategory> = categories.filter { it.isSelected }
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.task = newTasks
        taskAdapter.notifyDataSetChanged()

    }
}