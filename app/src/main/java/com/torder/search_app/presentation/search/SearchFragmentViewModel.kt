package com.torder.search_app.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.torder.search_app.domain.search.model.SearchResult
import com.torder.search_app.domain.search.usecase.GetSearchResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchFragmentViewModel @Inject constructor(
    private val getSearchResultUseCase: GetSearchResultUseCase
) : ViewModel() {

    private val _searchResult = MutableSharedFlow<List<SearchResult>>()
    val searchResult = _searchResult.asSharedFlow()

    fun getSearchResult(query: String) {
        viewModelScope.launch {
            getSearchResultUseCase(query)
                .onSuccess {
                    _searchResult.emit(it)
                }
        }
    }
}