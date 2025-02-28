package com.example.basestatecodelab.data

import com.google.gson.Gson

data class BannerModel(
    val title: String,
    val image: Int
){
    fun toGson(): String {
        return Gson().toJson(this)
    }

    fun fromGson(json: String): BannerModel {
        return Gson().fromJson(json, BannerModel::class.java)
    }
}