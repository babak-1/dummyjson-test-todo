package com.babak.retrofitapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiManager {

    @GET("todos/1")
    fun getTodo():Call<TodoModel>

    @GET("todos")
    fun getAllTodos():Call<AllTodosModel>


}