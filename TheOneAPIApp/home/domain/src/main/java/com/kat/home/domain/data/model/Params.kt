package com.kat.home.domain.data.model

data class Params(
    val total: String? = null,
    val limit: String? = DEFAULT_LIMIT,
    val offset: String? = DEFAULT_OFFSET,
    val page: String? = DEFAULT_PAGE,
    val pages: String? = null
) {

    companion object {
        const val DEFAULT_LIMIT = "100"
        const val DEFAULT_PAGE = "10"
        const val DEFAULT_OFFSET = "10"
    }

}