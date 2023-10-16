package com.torder.search_app.presentation.search.recyclerview

import android.view.ViewGroup
import com.torder.search_app.databinding.ItemSearchBinding
import com.torder.search_app.domain.search.model.SearchResult
import com.torder.search_app.presentation.base.CommonListAdapter

//private val listener: SearchAdapter.ImageListener
class SearchAdapter() :
    CommonListAdapter<SearchResult, ItemSearchBinding>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchViewHolder(parent)
            .apply(::setOnEventHolder)

    private fun setOnEventHolder(holder: SearchViewHolder) {
        holder.apply {
            binding.apply {
                clItem.setOnClickListener { }
            }
        }
    }

    interface ImageListener {
        fun onClickImage(item: SearchResult)
    }
}