package com.github.lanalebedeva.lebedevakinopoisk.film

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.lanalebedeva.lebedevakinopoisk.network.KinopoiskApi
import com.github.lanalebedeva.lebedevakinopoisk.network.SummaryFilm
import com.github.lanalebedeva.lebedevakinopoisk.topfilms.KinopoiskApiStatus
import kotlinx.coroutines.launch

class SummeryFilmViewModel : ViewModel() {

    private val _summaryFilm = MutableLiveData<SummaryFilm>()
    val summaryFilm: LiveData<SummaryFilm> = _summaryFilm

    private val _status = MutableLiveData<KinopoiskApiStatus>()
    val status: LiveData<KinopoiskApiStatus> = _status

    fun getSummeryFilm(id: String) {
        viewModelScope.launch {
            _status.value = KinopoiskApiStatus.LOADING
            try {
                _summaryFilm.value = KinopoiskApi.retrofitService.getSummaryFilm(id)
                _status.value = KinopoiskApiStatus.DONE
            } catch (e: Exception) {
                _status.value = KinopoiskApiStatus.ERROR
                _summaryFilm.value = SummaryFilm("", "", "", arrayOf(mapOf(Pair("", ""))), arrayOf(mapOf(Pair("", ""))))
            }
        }
    }
}