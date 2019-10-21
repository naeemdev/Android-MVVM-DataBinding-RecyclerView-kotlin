package com.androidmvvmdatabindingrecyclerviewkotlin.model

import android.util.Log
import android.widget.ImageView

import androidx.databinding.BindingAdapter


import com.androidmvvmdatabindingrecyclerviewkotlin.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName


class DeveloperModel {






    @SerializedName("login")
    var login: String? = null

    @SerializedName("avatar_url")
    var avatar_url: String? = null




    companion object  {

      
        @JvmStatic
        @BindingAdapter("avatar_url")
        fun loadImage(imageView: ImageView, imageURL: String) {

            Log.e("imsgeurl",imageURL)
            Glide.with(imageView.context)
                .setDefaultRequestOptions(
                    RequestOptions()
                        .circleCrop()
                )
                .load(imageURL)

                .into(imageView)
        }

    }



}
