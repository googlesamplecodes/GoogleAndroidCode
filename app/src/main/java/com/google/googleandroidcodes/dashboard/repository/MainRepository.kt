package com.google.llc.dashboard.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.google.llc.dashboard.models.TopHeadLineResponse
import com.google.llc.retrofit.NewsApi
import com.google.llc.retrofit.RetrofitClient
import com.google.llc.utils.NetworkResult
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.Error
import javax.inject.Inject

class MainRepository @Inject constructor(context: Context, var newsApi: NewsApi) {


    fun getNews(): MutableLiveData<NetworkResult<TopHeadLineResponse>> {
        val mutableNewslist = MutableLiveData<NetworkResult<TopHeadLineResponse>>()
        newsApi.getNews().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mutableNewslist.postValue(NetworkResult.Success(it))
            }, {
                it?.message?.let {
                    mutableNewslist.postValue((NetworkResult.Error(it)))
                }

            })
        return mutableNewslist
    }
}