package com.babak.retrofitapi


import com.google.gson.annotations.SerializedName

data class AllTodosModel(
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("skip")
    val skip: Int?,
    @SerializedName("todos")
    val todos: ArrayList<TodoModel>?,
    @SerializedName("total")
    val total: Int?
)