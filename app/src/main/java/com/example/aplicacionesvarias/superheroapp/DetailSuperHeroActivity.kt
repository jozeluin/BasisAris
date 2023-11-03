package com.example.aplicacionesvarias.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import com.example.aplicacionesvarias.databinding.ActivityDetailSuperHeroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperHeroActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding:ActivityDetailSuperHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailSuperHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
        Picasso.get().load(superhero.image.url).into(binding.ivSuperhero)
        binding.tvSuperheroName.text=superhero.name
        prepareStats(superhero.powerstats)
        binding.tvSuperheroRealName.text=superhero.biography.fullName
        binding.tvPublisher.text=superhero.biography.publisher

    }

    private fun prepareStats(powerstats: PowerStatResponse) {
        updateHeight(binding.viewCombat,powerstats.combat)
        updateHeight(binding.viewDurability,powerstats.durability)
        updateHeight(binding.viewIntelligence,powerstats.intelligence)
        updateHeight(binding.viewPower,powerstats.power)
        updateHeight(binding.viewSpeed,powerstats.speed)
        updateHeight(binding.viewStrength,powerstats.strength)

    }

    private fun pxToDp(px: Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,px,resources.displayMetrics).roundToInt()


    }

    private fun updateHeight(view:View,stat:String){
        val params=view.layoutParams
        params.height=pxToDp(stat.toFloat())
        view.layoutParams=params

    }


    private fun getretrofit(): Retrofit {

        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}