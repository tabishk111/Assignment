package com.example.recyclerassignment

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.newsapp.ui.DataViewModel
import com.androiddevs.newsapp.ui.DataViewModelProviderFactory
import com.example.recyclerassignment.repository.Repository
import com.example.recyclerassignment.ui.DataFragment

class MainActivity : AppCompatActivity() {

    var fragment: Fragment? = null
    lateinit var viewModel: DataViewModel
    private lateinit var actionBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBar = supportActionBar!!
        actionBar.title = "Robby Darling"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.my_gradient))

        val newsRepository = Repository()
        val viewModelProviderFactory = DataViewModelProviderFactory(application,newsRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(DataViewModel::class.java)

        val fm: FragmentManager = supportFragmentManager
        fragment = fm.findFragmentByTag("myFragmentTag")
        if (fragment == null) {
            val ft: FragmentTransaction = fm.beginTransaction()
            fragment = DataFragment()
            ft.add(android.R.id.content, fragment!!, "myFragmentTag")
            ft.commit()
        }
    }

    override fun onNavigateUp(): Boolean {
        return super.onNavigateUp()
    }
}