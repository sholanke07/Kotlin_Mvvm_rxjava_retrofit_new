package com.lateef.kotlinrxjava_retrofit_mvvm_new.Network

import com.lateef.kotlinrxjava_retrofit_mvvm_new.Model.PostModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getPosts(): Observable<MutableList<PostModel>>
}