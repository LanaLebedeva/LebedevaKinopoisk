package com.github.lanalebedeva.lebedevakinopoisk

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.lanalebedeva.lebedevakinopoisk.network.Film
import com.github.lanalebedeva.lebedevakinopoisk.topfilms.FilmAdapter
import coil.load
import com.github.lanalebedeva.lebedevakinopoisk.topfilms.KinopoiskApiStatus


/**
 * Updates the data shown in the [RecyclerView].
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Film>?) {
    val adapter = recyclerView.adapter as FilmAdapter
    adapter.submitList(data)
}

/**
 * Uses the Coil library to load an image by URL into an [ImageView]
 */
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(com.google.android.material.R.drawable.mtrl_ic_error)
        }
    }
}

@BindingAdapter("KinopoiskApiStatus")
fun bindStatus(statusImageView: ImageView, status: KinopoiskApiStatus) {
    when (status) {
        KinopoiskApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }

        KinopoiskApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.error_foreground)
        }

        KinopoiskApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
