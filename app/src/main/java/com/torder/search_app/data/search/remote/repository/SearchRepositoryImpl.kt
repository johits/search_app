package com.torder.search_app.data.search.remote.repository

import com.torder.search_app.data.search.remote.datasource.SearchDataSource
import com.torder.search_app.data.search.remote.mapper.toModel
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