package com.example.aplicacionesvarias.todoapp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionesvarias.R

class CategoriesViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val tvcategori_name: TextView=view.findViewById(R.id.tvcategori_name)
    private val vwdivider: View=view.findViewById(R.id.vwdivider)
    fun render(taskCategory: TaskCategory){
            tvcategori_name.text="Reprobando"

        when(taskCategory){
            TaskCategory.Business -> {
                tvcategori_name.text="Business"
                vwdivider.setBackgroundColor(
                    ContextCompat.getColor(vwdivider.context,R.color.todo_business_category)
                )
            }
            TaskCategory.Other -> {
                tvcategori_name.text="Other"
                vwdivider.setBackgroundColor(
                    ContextCompat.getColor(vwdivider.context,R.color.todo_other_category)
                )
            }
            TaskCategory.Personal -> {
                tvcategori_name.text="Personal"
                vwdivider.setBackgroundColor(
                    ContextCompat.getColor(vwdivider.context,R.color.todo_personal_category)
                )
            }
        }

    }
}