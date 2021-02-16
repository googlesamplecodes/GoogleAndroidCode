package com.google.llc.dashboard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.googleandroidcodes.R
import com.google.llc.dashboard.adapters.ItemListAdapter
import com.google.llc.dashboard.viewmodels.MainViewModels
import com.google.llc.utils.MyApp
import com.google.llc.utils.MyUtils
import com.google.llc.utils.NetworkResult
import com.learncoding.cleanarchitecture.viewmodels.ViewModelFactory_Factory
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    lateinit var recylerview: RecyclerView

    @Inject
    lateinit var listAdapter: ItemListAdapter

    @Inject
    lateinit var viewmodelfactory: ViewModelProvider.Factory
    val mainViewModels: MainViewModels by activityViewModels(){
        viewmodelfactory
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        MyApp.instance.mainDaggerComponent.inject(this)
        init(view)
        initRecylerview()
        observeViewModel()
        return view
    }

    fun init(view: View) {
        recylerview = view.findViewById(R.id.recylerview)

    }

    fun initRecylerview() {
        recylerview.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    fun observeViewModel() {
        mainViewModels.getAllNews().observe(viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> {
                    listAdapter.setData(it.data.articles)
                    MyUtils.showToastMsg(requireActivity(),it.data.status)
                }
                is NetworkResult.Error -> {
                    MyUtils.showToastMsg(requireActivity(),it.exception)
                }
            }
        })
    }
}