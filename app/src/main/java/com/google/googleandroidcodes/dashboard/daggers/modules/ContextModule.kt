package com.google.llc.dashboard.daggers.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(var context: Context) {

    @Singleton
    @Provides
    fun providesContext(): Context = context

}