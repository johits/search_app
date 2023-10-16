package com.torder.search_app.presentation.search.recyclerview

import android.view.ViewGroup
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.torder.search_app.R
import com.torder.search_app.databinding.ItemSearchBinding
import com.torder.search_app.domain.search.model.SearchResult

import com.torder.search_app.presentation.base.CommonViewHolder
import com.torder.search_app.presentation.toDateFormat

class SearchViewHolder(parent: ViewGroup) :
    CommonViewHolder<SearchResult, ItemSearchBinding>(
        R.layout.item_search,
        parent
    ) {


    override fun bind(item: SearchResult) {
        binding.apply {
            ivPlay.isVisible = item.kind == "video"
            Glide.with(context)
                .load(item.thumbnailUrl)
                .error(R.drawable.ic_launcher_background)
                .fallback(R.drawable.ic_launcher_background)
                .into(ivThumbnail)
            tvDateTime.text = item.datetime.toDateFormat()
        }
    }
}