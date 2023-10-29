package com.example.aplicacionesvarias.todoapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionesvarias.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvcategori_name: TextView = view.findViewById(R.id.tvcategori_name)
    private val vwdivider: View = view.findViewById(R.id.vwdivider)
    private val viewContainer: CardView = view.findViewById(R.id.viewContainer)




    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        var color = if (taskCategory.isSelected) {
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }

        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context,color))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        //  tvcategori_name.text="Reprobando"

        when (taskCategory) {
            TaskCategory.Business -> {
                tvcategori_name.text ="Negocios"
                vwdivider.setBackgroundColor(
                    ContextCompat.getColor(vwdivider.context, R.color.todo_business_category)
                )
            }

            TaskCategory.Other -> {
                tvcategori_name.text = "Other"
                vwdivider.setBackgroundColor(
                    ContextCompat.getColor(vwdivider.context, R.color.todo_other_category)
                )
            }

            TaskCategory.Personal -> {
                tvcategori_name.text = "Personal"
                vwdivider.setBackgroundColor(
                    ContextCompat.getColor(vwdivider.context, R.color.todo_personal_category)
                )
            }
        }

    }
}