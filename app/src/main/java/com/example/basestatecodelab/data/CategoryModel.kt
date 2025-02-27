package com.example.basestatecodelab.data

data class CategoryModel(
    val image: String? = null,
    val title: String
)


data class DataItem(
    val title: String,
    val categories: List<CategoryModel>
)