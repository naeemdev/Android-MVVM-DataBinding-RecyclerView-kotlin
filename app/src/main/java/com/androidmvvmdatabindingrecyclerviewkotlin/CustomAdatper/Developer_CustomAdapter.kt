package com.androidmvvmdatabindingrecyclerviewkotlin.CustomAdatper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView


import com.androidmvvmdatabindingrecyclerviewkotlin.R
import com.androidmvvmdatabindingrecyclerviewkotlin.databinding.SingleListItemBinding
import com.androidmvvmdatabindingrecyclerviewkotlin.model.DeveloperModel

import java.util.ArrayList

class Developer_CustomAdapter :
    RecyclerView.Adapter<Developer_CustomAdapter.DeveloperViewHolder>() {

    private var mDeveloperModel: ArrayList<DeveloperModel>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): DeveloperViewHolder {
        val mDeveloperListItemBinding = DataBindingUtil.inflate<SingleListItemBinding>(
            LayoutInflater.from(viewGroup.context),
            R.layout.single_list_item, viewGroup, false
        )

        return DeveloperViewHolder(mDeveloperListItemBinding)
    }

    override fun onBindViewHolder(mDeveloperViewHolder: DeveloperViewHolder, i: Int) {
        val currentStudent = mDeveloperModel!![i]
        mDeveloperViewHolder.mDeveloperListItemBinding.developerModel = currentStudent
    }

    override fun getItemCount(): Int {
        return if (mDeveloperModel != null) {
            mDeveloperModel!!.size
        } else {
            0
        }
    }

    fun setDeveloperList(mDeveloperModel: ArrayList<DeveloperModel>) {
        this.mDeveloperModel = mDeveloperModel
        notifyDataSetChanged()
    }

    inner class DeveloperViewHolder(var mDeveloperListItemBinding: SingleListItemBinding) :
        RecyclerView.ViewHolder(mDeveloperListItemBinding.root)
}
