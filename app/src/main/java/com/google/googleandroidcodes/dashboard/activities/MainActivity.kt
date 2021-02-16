package com.google.llc.dashboard.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.google.googleandroidcodes.R

import com.google.llc.dashboard.fragments.ListFragment
import com.google.llc.dashboard.viewmodels.MainViewModels
import com.google.llc.utils.MyApp
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewmodelfactory: ViewModelProvider.Factory
    val mainViewModels: MainViewModels by viewModels() {
        viewmodelfactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApp.instance.mainDaggerComponent.inject(this)
        replaceFragment(ListFragment())
    }

    /*
    Replace Fragment
     */
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framecontainer, fragment)
            .addToBackStack(null)
            .commit()

    }
}