package com.example.aplicacionesvarias.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionesvarias.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    private var bindig=ItemSuperheroBinding.bind(view)
    fun bind(superHeroItemResponse: SuperHeroItemResponse, onItemSelected: (String) -> Unit) {

        bindig.tvSuperheroName.text=superHeroItemResponse.name
        Picasso.get().load(superHeroItemResponse.superheroImage.url).into(bindig.ivSuperhero)
        bindig.root.setOnClickListener{onItemSelected(superHeroItemResponse.superheroId)}

    }


}