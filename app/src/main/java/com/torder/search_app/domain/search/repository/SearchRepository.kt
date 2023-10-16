package com.torder.search_app.domain.search.repository

import com.torder.search_app.domain.search.model.SearchResult


interface SearchRepository {
    suspend fun getImage(query: String): List<SearchResult>
    suspend fun getVideo(query: String): List<SearchResult>
}