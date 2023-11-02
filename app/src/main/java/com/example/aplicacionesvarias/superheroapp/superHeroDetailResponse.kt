package com.example.aplicacionesvarias.superheroapp

import com.google.gson.annotations.SerializedName

data class superHeroDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStatResponse,
    @SerializedName("image") val image: SuperHeroImageDetailResponse
)

data class PowerStatResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String


)

data class SuperHeroImageDetailResponse(@SerializedName ("url") val url:String)
