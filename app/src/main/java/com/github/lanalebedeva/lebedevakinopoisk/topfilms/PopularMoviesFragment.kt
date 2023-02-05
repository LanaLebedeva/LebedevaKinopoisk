package com.github.lanalebedeva.lebedevakinopoisk.topfilms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.github.lanalebedeva.lebedevakinopoisk.R
import com.github.lanalebedeva.lebedevakinopoisk.databinding.FragmentPopularMoviesBinding
import com.github.lanalebedeva.lebedevakinopoisk.film.FilmFragment

class PopularMoviesFragment : Fragment() {

    private val viewModel: PopularMoviesViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPopularMoviesBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.rvFilms.adapter = FilmAdapter {
            viewModel.setId(it.toString())
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragmentContainer, FilmFragment())
                .addToBackStack("First task")
                .commit()
        }
        return binding.root
    }
}
