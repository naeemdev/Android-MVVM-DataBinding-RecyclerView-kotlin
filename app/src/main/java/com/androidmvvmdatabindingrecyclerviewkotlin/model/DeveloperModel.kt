package com.androidmvvmdatabindingrecyclerviewkotlin.model

import android.widget.ImageView

import androidx.databinding.BindingAdapter


import com.androidmvvmdatabindingrecyclerviewkotlin.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName


class DeveloperModel {

    @SerializedName("username")
    var username: String? = null
    @SerializedName("name")
    var name: String? = null

    @SerializedName("avatar")
    var avatar: String? = null

    companion object {

        @BindingAdapter("avatar")
        fun loadImage(imageView: ImageView, imageURL: String) {

            Glide.with(imageView.context)
                .setDefaultRequestOptions(
                    RequestOptions()
                        .circleCrop()
                )
                .load(imageURL)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView)
        }
    }
}
