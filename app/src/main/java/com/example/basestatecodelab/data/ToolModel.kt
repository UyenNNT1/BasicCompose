package com.example.basestatecodelab.data

data class ToolModel(
    val title: String,
    val icon: Int,
    val status: ToolStatus,
)


enum class ToolStatus(val status: String){
    HOT("hot"),
    SOON("soon"),
    FREE("free"),
    NONE("none")
}