package com.google.llc.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class MyUtils {
    companion object {

        fun showToastMsg(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        fun callImageLibrary(context: Context, url: String, view: ImageView) {
            Glide.with(context!!).load(url).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view)
        }
    }
}
