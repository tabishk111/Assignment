package com.example.recyclerassignment.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevs.newsapp.ui.DataViewModel
import com.example.recyclerassignment.MainActivity
import com.example.recyclerassignment.R
import com.example.recyclerassignment.adapter.Adapter
import kotlinx.android.synthetic.main.fragment_data.*

class DataFragment : Fragment(R.layout.fragment_data) {

    lateinit var viewModel: DataViewModel
    lateinit var myadapter: Adapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setUpRecyclerView()

        viewModel.data.observe(viewLifecycleOwner, Observer {
            it.let {
                myadapter.differ.submitList(it)
            }
        })

    }

    private fun setUpRecyclerView(){
        myadapter = Adapter()
        recyclerView.apply {
            adapter = myadapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}