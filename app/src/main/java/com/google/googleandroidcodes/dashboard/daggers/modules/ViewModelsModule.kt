package com.google.llc.dashboard.daggers.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.llc.dashboard.viewmodels.MainViewModels
import com.learncoding.cleanarchitecture.viewmodels.ViewModelFactory
import com.learncoding.cleanarchitecture.viewmodels.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelsModule {


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModels::class)
    abstract fun provideHomeViewModel(homeViewModel: MainViewModels):ViewModel


    @Binds
    @Singleton
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory):ViewModelProvider.Factory
}