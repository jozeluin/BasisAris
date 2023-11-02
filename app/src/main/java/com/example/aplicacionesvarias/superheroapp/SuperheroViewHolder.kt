package com.example.aplicacionesvarias.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionesvarias.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    private var bindig=ItemSuperheroBinding.bind(view)
    fun bind(superHeroItemResponse: SuperHeroItemResponse) {

        bindig.tvSuperheroName.text=superHeroItemResponse.name

        Picasso.get().load(superHeroItemResponse.superheroImage.url).into(bindig.ivSuperhero)

    }


}