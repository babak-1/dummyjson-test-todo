package com.babak.retrofitapi

class ApitUtils {
    companion object{
        fun createApi():ApiManager{
            return RetrofitClient.retrofit.create(ApiManager::class.java)
        }
    }
}