package com.example.aplicacionesvarias.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionesvarias.R

class SuperHeroAdapter(var superheroList:List<SuperHeroItemResponse> = emptyList()) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(superheroList:List<SuperHeroItemResponse>){
        this.superheroList = superheroList
        notifyDataSetChanged()
    }

    /**
     * Aqui abajo especificamos el layout a utilizar
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return SuperheroViewHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    /**
     * Posicion de la lista que se entrega al viewholder para que la pinte
     */
    override fun onBindViewHolder(viewholder: SuperheroViewHolder, position: Int) {
               viewholder.bind(superheroList[position])
    }
    override fun getItemCount()=superheroList.size


}