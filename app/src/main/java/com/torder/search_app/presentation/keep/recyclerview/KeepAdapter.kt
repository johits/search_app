package com.torder.search_app.presentation.keep.recyclerview

import android.view.ViewGroup
import com.torder.search_app.databinding.ItemSearchBinding
import com.torder.search_app.domain.keep.model.KeepModel
import com.torder.search_app.presentation.base.CommonListAdapter

class KeepAdapter(private val listener: KeepListener) :
    CommonListAdapter<KeepModel, ItemSearchBinding>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        KeepViewHolder(parent)
            .apply(::setOnEventHolder)

    private fun setOnEventHolder(holder: KeepViewHolder) {
        holder.apply {
            binding.apply {
                cbHeart.setOnClickListener {
                    listener.onClickHeart(
                        getItem(adapterPosition),
                        cbHeart.isChecked
                    )
                }
            }
        }
    }


    interface KeepListener {
        fun onClickHeart(item: KeepModel, isHeart: Boolean)
    }
}