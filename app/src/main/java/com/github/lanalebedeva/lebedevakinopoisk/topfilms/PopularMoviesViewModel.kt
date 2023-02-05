package com.github.lanalebedeva.lebedevakinopoisk.topfilms

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.lanalebedeva.lebedevakinopoisk.network.Film
import com.github.lanalebedeva.lebedevakinopoisk.network.KinopoiskApi
import kotlinx.coroutines.launch

enum class KinopoiskApiStatus { LOADING, ERROR, DONE }
class PopularMoviesViewModel : ViewModel() {

    private val _status = MutableLiveData<KinopoiskApiStatus>()
    val status: LiveData<KinopoiskApiStatus> = _status

    private val _film = MutableLiveData<List<Film>>()
    val film: LiveData<List<Film>> = _film

    init {
        getFilms()
    }

    private fun getFilms() {
        viewModelScope.launch {
            _status.value = KinopoiskApiStatus.LOADING
            try {
                _film.value= KinopoiskApi.retrofitService.getTopFilms(
                    "TOP_100_POPULAR_FILMS", 1
                ).films
                Log.d("TAAG", film.value.toString() + "OK")
                _status.value = KinopoiskApiStatus.DONE
            } catch (e: Exception) {
                Log.d("TAAG", e.toString())
                Log.d("TAAG", e.message.toString() + "ERROR")
                _status.value = KinopoiskApiStatus.ERROR
                _film.value = listOf<Film>()
            }
        }
    }
}
