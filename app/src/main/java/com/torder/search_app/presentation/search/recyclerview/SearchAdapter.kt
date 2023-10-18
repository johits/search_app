package com.torder.search_app.presentation.search.recyclerview

import android.view.ViewGroup
import com.torder.search_app.databinding.ItemSearchBinding
import com.torder.search_app.domain.search.model.SearchResult
import com.torder.search_app.presentation.base.CommonListAdapter

class SearchAdapter(private val listener: SearchListener) :
    CommonListAdapter<SearchResult, ItemSearchBinding>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchViewHolder(parent)
            .apply(::setOnEventHolder)

    private fun setOnEventHolder(holder: SearchViewHolder) {
        holder.apply {
            binding.apply {
                cbHeart.setOnClickListener {
                    listener.onClickHeart(getItem(adapterPosition), cbHeart.isChecked)
                }
            }
        }
    }

    interface SearchListener {
        fun onClickHeart(item: SearchResult, isHeart: Boolean)
    }
}