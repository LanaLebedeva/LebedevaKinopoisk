package com.github.lanalebedeva.lebedevakinopoisk.topfilms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.github.lanalebedeva.lebedevakinopoisk.databinding.FragmentPopularMoviesBinding

class PopularMoviesFragment : Fragment() {

    private val viewModel: PopularMoviesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPopularMoviesBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.rvFilms.adapter = FilmAdapter()

        return binding.root
    }
}
