package com.example.aplicacionesvarias.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/1732892627209770/search/{name}")
    suspend fun getSuperheroes(@Path("name") superhero:String):Response<SuperHeroDataResponse>
    /*
    https://superheroapi.com/api/access-token/character-id solo necesitamos esto /api/access-token/character-id
    ya que lo otro lo colocabamos al crear retrofit
     */


    @GET("/api/1732892627209770/{id}")
    suspend fun getSuperHeroId(@Path("id") superheroId:String):Response<superHeroDetailResponse>



}