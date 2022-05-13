package com.kat.home.domain.data.model.modeltypes

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ResponseBook(
    @Json(name = "docs") val docs: List<Book>? = null,
    @Json(name = "total") val total: Int? = null,
    @Json(name = "limit") val limit: Int? = null,
    @Json(name = "offset") val offset: Int? = null,
    @Json(name = "page") val page: Int? = null,
    @Json(name = "pages") val pages: Int? = null
)

@Keep
data class Book(
    @Json(name = "_id") val id: String? = null,
    @Json(name = "name") val name: String? = null
)
