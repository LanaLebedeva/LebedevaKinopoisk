package com.github.lanalebedeva.lebedevakinopoisk.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.github.lanalebedeva.lebedevakinopoisk.databinding.FragmentFilmBinding
import com.github.lanalebedeva.lebedevakinopoisk.topfilms.PopularMoviesViewModel

class FilmFragment : Fragment() {
    private val viewModel: SummeryFilmViewModel by activityViewModels()
    private val viewModelPopular: PopularMoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFilmBinding.inflate(inflater)
        binding.lifecycleOwner = this
        viewModel.getSummeryFilm(viewModelPopular.idFilms.value!!)
        binding.viewModel= viewModel
        return binding.root
    }
}
