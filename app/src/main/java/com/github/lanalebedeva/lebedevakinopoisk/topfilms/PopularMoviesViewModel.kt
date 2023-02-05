package com.github.lanalebedeva.lebedevakinopoisk.topfilms

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

    private val _idFilms = MutableLiveData<String>("4370148")
    val idFilms: LiveData<String> = _idFilms

    init {
        getFilms()

    }

    private fun getFilms() {
        viewModelScope.launch {
            _status.value = KinopoiskApiStatus.LOADING
            try {
                _film.value = KinopoiskApi.retrofitService.getTopFilms(
                    "TOP_100_POPULAR_FILMS", 1
                ).films
                _status.value = KinopoiskApiStatus.DONE
            } catch (e: Exception) {
                _status.value = KinopoiskApiStatus.ERROR
                _film.value = listOf<Film>()
            }
        }
    }

    fun setId(id: String) {
        _idFilms.value = id
    }
}
