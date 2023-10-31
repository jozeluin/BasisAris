package com.example.aplicacionesvarias.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/1732892627209770/search/{name}")
    suspend fun getSuperheroes(@Path("name") superhero:String):Response<>


}