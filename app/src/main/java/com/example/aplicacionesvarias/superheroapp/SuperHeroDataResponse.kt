package com.example.aplicacionesvarias.superheroapp

import com.google.gson.annotations.SerializedName


data class SuperHeroDataResponse(
    @SerializedName("response")val response:String,
    @SerializedName("results")val superherores:List<SuperHeroItemResponse>)

data class SuperHeroItemResponse (
    @SerializedName("id") val superheroId:String,
    @SerializedName("name") val name:String
)