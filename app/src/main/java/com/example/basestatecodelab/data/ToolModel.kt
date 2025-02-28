package com.example.basestatecodelab.data

import com.google.gson.Gson

data class ToolModel(
    val title: String,
    val icon: Int,
    val status: ToolStatus,
) {
    fun toGson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromGson(json: String): ToolModel {
            return Gson().fromJson(json, ToolModel::class.java)
        }
    }
}


enum class ToolStatus(val status: String) {
    HOT("hot"),
    SOON("soon"),
    FREE("free"),
    NONE("none")
}