package com.lateef.kotlinrxjava_retrofit_mvvm_new.Repository

import androidx.lifecycle.MutableLiveData
import com.lateef.kotlinrxjava_retrofit_mvvm_new.Common.Common
import com.lateef.kotlinrxjava_retrofit_mvvm_new.Model.PostModel
import com.lateef.kotlinrxjava_retrofit_mvvm_new.Network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository {

    private val apiService: ApiService
    private val compositeDisposable = CompositeDisposable()

    init {
        apiService = Common.getApiService
    }

    val getPostModelLiveData: MutableLiveData<MutableList<PostModel>>
    get() {
        val data: MutableLiveData<MutableList<PostModel>> = MutableLiveData<MutableList<PostModel>>()
        compositeDisposable.add(apiService.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{postmodels ->
                if (postmodels != null){
                    data.value = postmodels
                }
            })
              return data

    }
}