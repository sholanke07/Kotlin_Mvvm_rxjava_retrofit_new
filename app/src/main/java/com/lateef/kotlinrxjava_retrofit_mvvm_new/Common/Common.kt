package com.lateef.kotlinrxjava_retrofit_mvvm_new.Common

import com.lateef.kotlinrxjava_retrofit_mvvm_new.Network.ApiService
import com.lateef.kotlinrxjava_retrofit_mvvm_new.Network.RetrofitClient
import retrofit2.create

object Common {

    private const val BASE_URL = "http://jsonplaceholder.typicode.com/"

    val getApiService: ApiService
    get() = RetrofitClient.getRetrofitClient(BASE_URL).create(ApiService::class.java)
}