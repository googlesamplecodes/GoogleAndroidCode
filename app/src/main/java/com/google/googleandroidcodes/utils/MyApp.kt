package com.google.llc.utils

import android.app.Application
import com.google.llc.dashboard.daggers.components.DaggerMainComponent
import com.google.llc.dashboard.daggers.components.MainComponent
import com.google.llc.dashboard.daggers.modules.AppModule
import com.google.llc.dashboard.daggers.modules.ContextModule

class MyApp : Application() {

    companion object {
        lateinit var instance: MyApp
    }

    lateinit var mainDaggerComponent: MainComponent
    override fun onCreate() {
        super.onCreate()
        instance = this
        mainDaggerComponent =
            DaggerMainComponent.builder().contextModule(ContextModule(this)).appModule(
                AppModule(this)
            ).build()

    }
}