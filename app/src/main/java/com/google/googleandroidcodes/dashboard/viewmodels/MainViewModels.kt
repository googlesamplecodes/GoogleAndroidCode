package com.google.llc.dashboard.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.llc.dashboard.models.TopHeadLineResponse
import com.google.llc.dashboard.repository.MainRepository
import com.google.llc.utils.NetworkResult
import javax.inject.Inject

class MainViewModels @Inject constructor(
    application: Application,
    var mainRepository: MainRepository
) :
    AndroidViewModel(application) {


    fun getAllNews(): MutableLiveData<NetworkResult<TopHeadLineResponse>> {
        return mainRepository.getNews()
    }

    override fun onCleared() {
        super.onCleared()
        mainRepository.clear()
    }
}