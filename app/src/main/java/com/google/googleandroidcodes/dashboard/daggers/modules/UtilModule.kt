package com.google.llc.dashboard.daggers.modules

import com.google.llc.utils.MyUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilModule {

    @Singleton
    @Provides
    fun provideMyUtil():MyUtils{
        return MyUtils()
    }
}