package com.example.salahtimes

import com.example.salahtimes.model.Item

interface ISalatView{

    fun onDataCompleteFromAPi(salat: Item)
    fun onDataErrorFromApi(throwable: Throwable)
}