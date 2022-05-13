package com.kat.home.domain.data.model.modeltypes

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ResponseMovie(
    @Json(name = "docs") val docs: List<Movie>? = null,
    @Json(name = "total") val total: Int? = null,
    @Json(name = "limit") val limit: Int? = null,
    @Json(name = "offset") val offset: Int? = null,
    @Json(name = "page") val page: Int? = null,
    @Json(name = "pages") val pages: Int? = null
)

@Keep
data class Movie(
    @Json(name = "_id") val id: String? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "runtimeInMinutes") val runtimeInMinutes: String? = null,
    @Json(name = "budgetInMillions") val budgetInMillions: String? = null,
    @Json(name = "boxOfficeRevenueInMillions") val boxOfficeRevenueInMillions: String? = null,
    @Json(name = "academyAwardNominations") val academyAwardNominations: String? = null,
    @Json(name = "academyAwardWins") val academyAwardWins: String? = null,
    @Json(name = "rottenTomatoesScore") val rottenTomatoesScore: String? = null
)
