package com.github.lanalebedeva.lebedevakinopoisk.network

import com.squareup.moshi.Json

data class ResponseFilm(
    @Json(name = "pagesCount") val pagesCount: Int,
    @Json(name = "films") val films: List<Film>
)

data class Film(
    @Json(name = "filmId") val filmId: String,
    @Json(name = "nameRu") val nameRu: String,
    @Json(name = "posterUrlPreview") val posterUrlPreview: String,
    @Json(name = "year") val year: String,
    @Json(name = "genres") val genres: Array<Map<String, String>>,
) {
    val genresString = genres.map { mapGenres ->
        mapGenres.entries.joinToString {
            it.value
        }
    }.joinToString(separator = ", ", prefix = "", postfix = "", limit = 2, truncated = "...")

}
