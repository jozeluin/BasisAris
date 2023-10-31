package com.example.aplicacionesvarias.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicacionesvarias.R
import com.example.aplicacionesvarias.databinding.ActivitySuperHeroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class  SuperHeroListActivity : AppCompatActivity() {

    private lateinit var bindig:ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit

    private lateinit var adapter: SuperHeroAdapter

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

        adapter= SuperHeroAdapter()
        bindig.rvSuperhero.setHasFixedSize(true)
        bindig.rvSuperhero.layoutManager=LinearLayoutManager(this)
        bindig.rvSuperhero.adapter=adapter

    }

    private fun searchByName(query: String) {
        bindig.progressBar.isVisible=true
        CoroutineScope(Dispatchers.IO).launch{
            val myResponse=retrofit.create(ApiService::class.java).getSuperheroes(query)
            if(myResponse.isSuccessful){
                Log.i("JoseLuis","funciono :)")

                val response: SuperHeroDataResponse? =myResponse.body()
                if(response!=null){
                    Log.i("JoseLuis",response.toString())
                    runOnUiThread{//Lo que colocoque entre llaves corre en el hilo principal
                        //por que si no da error lo siguiente
                        adapter.updateList(response.superherores)
                        bindig.progressBar.isVisible=false
                    }

                }
            }else{
                Log.i("JoseLuis","No funciono :(")
            }

        }

    }

    private fun getretrofit():Retrofit{

       return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}