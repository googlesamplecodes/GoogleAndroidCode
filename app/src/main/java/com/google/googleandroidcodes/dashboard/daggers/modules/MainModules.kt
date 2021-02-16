package com.google.llc.dashboard.daggers.modules

import android.content.Context
import com.google.llc.dashboard.repository.MainRepository
import com.google.llc.retrofit.NewsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainModules {

    @Singleton
    @Provides
    fun providesMainRepository(context: Context, newsApi: NewsApi): MainRepository {
        return MainRepository(context, newsApi)
    }

}