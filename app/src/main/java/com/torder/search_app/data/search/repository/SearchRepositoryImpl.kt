package com.torder.search_app.data.search.repository

import com.torder.search_app.data.search.datasource.SearchDataSource
import com.torder.search_app.data.search.mapper.toModel
import com.torder.search_app.domain.search.model.SearchResult
import com.torder.search_app.domain.search.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchDataSource: SearchDataSource
) : SearchRepository {
    override suspend fun getImage(query: String): List<SearchResult> {
        return searchDataSource.getImage(query).map {
            it.toModel()
        }
    }

    override suspend fun getVideo(query: String): List<SearchResult> {
        return searchDataSource.getVideo(query).map {
            it.toModel()
        }
    }
}