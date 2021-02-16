package com.google.llc.dashboard.daggers.modules

import android.content.Context
import com.google.llc.retrofit.NewsApi
import com.google.llc.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClietn(): RetrofitClient {
        return RetrofitClient()
    }

    @Singleton
    @Provides
    fun provideOkHttp(context: Context): OkHttpClient {
        return RetrofitClient.okHttp(context)
    }

    @Singleton
    @Provides
    fun provideNewsApi(context: Context): NewsApi {
        return RetrofitClient.create(context)
    }
}