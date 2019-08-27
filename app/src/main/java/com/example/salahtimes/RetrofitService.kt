package com.example.salahtimes

import com.example.salahtimes.model.solat
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService{


    @GET("{city}.json?key=4a3da4b671795d087dc4f608e2afae2f")
    fun getAPi(@Path("city") city: String): Call<solat>

    companion object {
        fun create(): RetrofitService{

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://muslimsalat.com")
                    .build()
            return retrofit.create(RetrofitService::class.java)
        }

    }
}