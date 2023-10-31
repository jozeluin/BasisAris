package com.example.aplicacionesvarias.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.widget.SearchView
import com.example.aplicacionesvarias.R
import com.example.aplicacionesvarias.databinding.ActivitySuperHeroListBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class  SuperHeroListActivity : AppCompatActivity() {

    private lateinit var bindig:ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig= ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(bindig.root)
        retrofit=getretrofit()
        initUI()
    }

    private fun initUI() {
        bindig.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            //Buscara cuando le demos a la lupa
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())//si es null  devuelvo texto vacio, devolveria todos los superheroes

                return false
            }
            //Buscar mientras escribimos, no nos interesa
            override fun onQueryTextChange(newText: String?)= false

        })
    }

    private fun searchByName(query: String) {

    }

    private fun getretrofit():Retrofit{

       return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}