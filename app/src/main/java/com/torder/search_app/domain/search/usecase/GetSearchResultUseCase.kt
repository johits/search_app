package com.torder.search_app.domain.search.usecase


import com.torder.search_app.domain.search.model.SearchResult
import com.torder.search_app.domain.search.repository.SearchRepository
import kotlinx.coroutines.flow.flattenMerge
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import javax.inject.Inject


class GetSearchResultUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {
    suspend operator fun invoke(
        query: String
    ): Result<List<SearchResult>> {
        val image = flowOf(searchRepository.getImage(query))
        val video = flowOf(searchRepository.getVideo(query))
        return kotlin.runCatching {
            flowOf(image, video)
                .flattenMerge()
                .toList()
                .flatten()
        }
    }
}