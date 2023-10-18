package com.torder.search_app.presentation.search

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import com.torder.search_app.R
import com.torder.search_app.databinding.FragmentSearchBinding
import com.torder.search_app.domain.search.model.SearchResult
import com.torder.search_app.presentation.base.CommonFragment
import com.torder.search_app.presentation.keep.KeepFragmentViewModel
import com.torder.search_app.presentation.mapper.toKeepModel
import com.torder.search_app.presentation.search.recyclerview.SearchAdapter
import com.torder.search_app.presentation.toSeconds
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : CommonFragment<FragmentSearchBinding>(
    R.layout.fragment_search
) {
    private lateinit var adapter: SearchAdapter
    private val searchViewModel: SearchFragmentViewModel by activityViewModels()
    private val keepViewModel: KeepFragmentViewModel by activityViewModels()

    override fun onInitBinding() {
        super.onInitBinding()
        adapter = SearchAdapter(SearchListener())
        binding.rvSearch.adapter = adapter
        binding.btnSearch.setOnClickListener {
            searchViewModel.getSearchResult(binding.etSearch.text.toString())
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun observeData() {
        super.observeData()
        lifecycleScope.launch {
            searchViewModel.searchResult.collect {
                adapter.submitList(it.sortedByDescending { searchResult ->
                    searchResult.datetime.toSeconds()
                })
            }
        }
    }

    private inner class SearchListener : SearchAdapter.SearchListener {
        override fun onClickHeart(item: SearchResult, isHeart: Boolean) {
            when (isHeart) {
                true -> keepViewModel.insertHeart(item.copy(isHeart = true).toKeepModel())
                false -> keepViewModel.deleteHeart(item.thumbnailUrl)
            }
            val heartGuid = if (isHeart) "보관하였습니다." else "보관 취소하였습니다."
            Toast.makeText(context, heartGuid, Toast.LENGTH_SHORT).show()
        }
    }
}

