package com.kat.home.domain.data.model.modeltypes

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class ResponseCharacter(
    @Json(name = "docs") val docs: List<Character>? = null,
    @Json(name = "total") val total: Int? = null,
    @Json(name = "limit") val limit: Int? = null,
    @Json(name = "offset") val offset: Int? = null,
    @Json(name = "page") val page: Int? = null,
    @Json(name = "pages") val pages: Int? = null
)

@Keep
data class Character(
    @Json(name = "_id") val id: String? = null,
    @Json(name = "height") val height: String? = null,
    @Json(name = "race") val race: String? = null,
    @Json(name = "gender") val gender: String? = null,
    @Json(name = "birth") val birth: String? = null,
    @Json(name = "spouse") val spouse: String? = null,
    @Json(name = "death") val death: String? = null,
    @Json(name = "realm") val realm: String? = null,
    @Json(name = "hair") val hair: String? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "wikiUrl") val wikiUrl: String? = null
)
