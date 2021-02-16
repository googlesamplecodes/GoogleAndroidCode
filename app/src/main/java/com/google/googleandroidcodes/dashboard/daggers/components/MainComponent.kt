package com.google.llc.dashboard.daggers.components

import com.google.llc.dashboard.activities.MainActivity
import com.google.llc.dashboard.daggers.modules.*
import com.google.llc.dashboard.fragments.ListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ContextModule::class, NetworkModule::class, ViewModelsModule::class, MainModules::class, UtilModule::class])
interface MainComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(fragment: ListFragment)

}