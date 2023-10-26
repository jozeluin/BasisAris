package com.example.aplicacionesvarias.todoapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.Optional.empty

class TasksAdapter(private val task: List<Task>): RecyclerView.Adapter<TaskViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return null
    }



    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {

    }

    override fun getItemCount()=task.size


}