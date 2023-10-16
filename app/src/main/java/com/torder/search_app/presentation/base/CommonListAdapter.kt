package com.torder.search_app.presentation.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class CommonListAdapter<T : Any, B : ViewDataBinding>(
    diffCallback: DiffUtil.ItemCallback<T> = CommonDiffCallback as DiffUtil.ItemCallback<T>,
) : ListAdapter<T, CommonViewHolder<T, B>>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder<T, B> {
        return CommonViewHolder(viewType, parent)
    }

    override fun onBindViewHolder(holder: CommonViewHolder<T, B>, position: Int) {
        holder.bind(getItem(position))
    }
}