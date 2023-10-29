package com.example.aplicacionesvarias.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionesvarias.R


class CategoriesAdapter(private val categories: List<TaskCategory>,private val onItemSelected:(Int)->Unit) :
    RecyclerView.Adapter<CategoriesViewHolder>() {

    //Monta vista,
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_task_category,parent,false)
        return CategoriesViewHolder(view)

    }


    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position],onItemSelected)
    }

    override fun getItemCount() = categories.size


}