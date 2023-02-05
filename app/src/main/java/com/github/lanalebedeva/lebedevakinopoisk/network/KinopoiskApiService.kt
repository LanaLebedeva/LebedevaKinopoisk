package com.github.lanalebedeva.lebedevakinopoisk.network

import retrofit2.Retrofit
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query




private const val BASE_URL =
    "https://kinopoiskapiunofficial.tech"

private const val KEY = "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface KinopoiskApiService {
    @Headers("X-API-KEY: $KEY", "Content-Type: application/json")
    @GET(value = "/api/v2.2/films/top")
    suspend fun getTopFilms(@Query("type") type: String, @Query("page") page: Int): ResponseFilm
}

object KinopoiskApi {
    val retrofitService: KinopoiskApiService by lazy { retrofit.create(KinopoiskApiService::class.java) }
}
