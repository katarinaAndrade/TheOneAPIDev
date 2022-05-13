package com.kat.home.domain.data.model.modeltypes

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ResponseQuote(
    @Json(name = "docs") val docs: List<Quote>? = null,
    @Json(name = "total") val total: Int? = null,
    @Json(name = "limit") val limit: Int? = null,
    @Json(name = "offset") val offset: Int? = null,
    @Json(name = "page") val page: Int? = null,
    @Json(name = "pages") val pages: Int? = null
)

@Keep
data class Quote(
    @Json(name = "_id") val idQuote: String? = null,
    @Json(name = "dialog") val dialog: String? = null,
    @Json(name = "movie") val movie: String? = null,
    @Json(name = "character") val character: String? = null,
    @Json(name = "id") val id: String? = null
)