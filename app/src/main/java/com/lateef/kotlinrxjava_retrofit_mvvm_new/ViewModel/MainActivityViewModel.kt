package com.lateef.kotlinrxjava_retrofit_mvvm_new.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lateef.kotlinrxjava_retrofit_mvvm_new.Model.PostModel
import com.lateef.kotlinrxjava_retrofit_mvvm_new.Repository.MainRepository

class MainActivityViewModel: ViewModel() {

    private lateinit var mainRepository: MainRepository

    init {
        mainRepository = MainRepository()
    }

    val getPostList: LiveData<MutableList<PostModel>>
    get() = mainRepository.getPostModelLiveData
}