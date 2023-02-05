package com.github.lanalebedeva.lebedevakinopoisk.network

import com.squareup.moshi.Json

data class SummaryFilm(
    @Json(name = "nameRu") val nameRu: String,
    @Json(name = "posterUrl") val posterUrl: String,
    @Json(name = "description") val shortDescription: String,
    @Json(name = "countries") val countries: Array<Map<String, String>>,
    @Json(name = "genres") val genres: Array<Map<String, String>>,
) {
    val genresString = genres.map { mapGenres ->
        mapGenres.entries.joinToString {
            it.value
        }
    }.joinToString(separator = ", ", prefix = "", postfix = "", limit = 2, truncated = "...")

    val countriesString = countries.map { mapCountries ->
        mapCountries.entries.joinToString {
            it.value
        }
    }.joinToString(separator = ", ", prefix = "", postfix = "", limit = 10, truncated = "...")

}
