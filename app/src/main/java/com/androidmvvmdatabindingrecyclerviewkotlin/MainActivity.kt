package com.androidmvvmdatabindingrecyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidmvvmdatabindingrecyclerviewkotlin.CustomAdatper.Developer_CustomAdapter
import com.androidmvvmdatabindingrecyclerviewkotlin.databinding.ActivityMainBinding
import com.androidmvvmdatabindingrecyclerviewkotlin.model.DeveloperModel
import com.androidmvvmdatabindingrecyclerviewkotlin.viewmodel.DeveloperViewModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    internal var activityMainBinding: ActivityMainBinding?= null
    internal var loadBar : ProgressBar ? = null
     var mainViewModel: DeveloperViewModel? = null
    private var mDeveloper_CustomAdapter: Developer_CustomAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main);

        // bind RecyclerView
        val recyclerView = activityMainBinding?.viewdeveloper
        loadBar = activityMainBinding!!.loadBar
        recyclerView!!.setLayoutManager(LinearLayoutManager(this))
        recyclerView!!.setHasFixedSize(true)

        ///init the View Model
        mainViewModel = ViewModelProviders.of(this).get(DeveloperViewModel::class.java)

        //init the Custom adataper
        mDeveloper_CustomAdapter = Developer_CustomAdapter()
        //set the CustomAdapter
        recyclerView.setAdapter(mDeveloper_CustomAdapter)

        getAllDev()
    }

    private fun getAllDev() {
        ///get the list of dev from api response
        mainViewModel!!.allDeveloper.observe(this,
            Observer<List<Any>> { mDeveloperModel ->
                ///if any thing chnage the update the UI
                mDeveloper_CustomAdapter?.setDeveloperList(mDeveloperModel as ArrayList<DeveloperModel>)
                loadBar?.visibility = View.GONE
            })
    }
}
