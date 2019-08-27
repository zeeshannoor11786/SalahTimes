package com.example.salahtimes

import android.content.Context
import com.example.salahtimes.model.Item
import com.example.salahtimes.model.solat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SalatPresenter(context: Context){
    val salatView = context as ISalatView

    fun getDataFromApi(city: String){
        RetrofitService.create()
                .getAPi(city)
                .enqueue(object : Callback<solat> {
                    override fun onFailure(call: Call<solat>, t: Throwable) {

                        salatView.onDataErrorFromApi(t)
                    }

                    override fun onResponse(call: Call<solat>, response: Response<solat>) {

                        salatView.onDataCompleteFromAPi(response.body()?.items?.get(0) as Item)
                    }

                })

    }

}

