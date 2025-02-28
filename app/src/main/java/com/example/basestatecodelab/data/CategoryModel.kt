package com.example.basestatecodelab.data

import com.google.gson.Gson

data class CategoryModel(
    val image: String? = null,
    val title: String
) {
    fun toGson(): String {
        return Gson().toJson(this)
    }

    fun fromGson(json: String): CategoryModel {
        return Gson().fromJson(json, CategoryModel::class.java)
    }

}

data class DataItem(
    val title: String,
    val categories: List<CategoryModel>
)