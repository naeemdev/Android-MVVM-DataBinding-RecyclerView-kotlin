package com.androidmvvmdatabindingrecyclerviewkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


import com.androidmvvmdatabindingrecyclerviewkotlin.model.DeveloperModel
import com.androidmvvmdatabindingrecyclerviewkotlin.repository.DeveloperRepository


class DeveloperViewModel(application: Application) : AndroidViewModel(application) {
    private val mDeveloperRepository: DeveloperRepository

    val allDeveloper: LiveData<List<DeveloperModel>>
        get() = mDeveloperRepository.getMutableLiveData()

    init {
        mDeveloperRepository = DeveloperRepository()
    }
}
