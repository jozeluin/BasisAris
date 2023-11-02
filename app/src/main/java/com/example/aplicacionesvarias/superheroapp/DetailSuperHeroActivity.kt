package com.example.aplicacionesvarias.superheroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplicacionesvarias.R
import com.example.aplicacionesvarias.databinding.ActivityDetailSuperHeroBinding
import com.example.aplicacionesvarias.databinding.ActivitySuperHeroListBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DetailSuperHeroActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_ID = "extra_id"
    }

    private lateinit var bindig:ActivityDetailSuperHeroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig= ActivityDetailSuperHeroBinding.inflate(layoutInflater)
        setContentView(bindig.root)
        val id = intent.getStringExtra(EXTRA_ID).orEmpty()//orEmpty si es nulo,devolvera vacio
        getSuperHeroInformation(id)
    }

    private fun getSuperHeroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail = getretrofit().create(ApiService::class.java).getSuperHeroId(id)
            if(superheroDetail.body()!=null){
                runOnUiThread{createdUI(superheroDetail.body()!!)}
            }

        }
    }

    private fun createdUI(superhero: superHeroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(bindig.ivSuperhero)
        bindig.tvSuperheroName.text=superhero.name

    }

    private fun getretrofit(): Retrofit {

        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}