package com.torder.search_app.presentation.keep

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import com.torder.search_app.R
import com.torder.search_app.databinding.FragmentKeepBinding
import com.torder.search_app.domain.keep.model.KeepModel
import com.torder.search_app.presentation.base.CommonFragment
import com.torder.search_app.presentation.keep.recyclerview.KeepAdapter
import com.torder.search_app.presentation.toSeconds
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class KeepFragment : CommonFragment<FragmentKeepBinding>(
    R.layout.fragment_keep
) {
    private lateinit var keepAdapter: KeepAdapter
    private val keepViewModel: KeepFragmentViewModel by activityViewModels()

    override fun onInitBinding() {
        super.onInitBinding()
        keepAdapter = KeepAdapter(KeepListener())
        binding.rvKeep.adapter = keepAdapter
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun observeData() {
        super.observeData()
        lifecycleScope.launch {
            keepViewModel.keepList.collect {
                keepAdapter.submitList(it.sortedByDescending { keepList ->
                    keepList.datetime.toSeconds()
                })
            }
        }
    }

    inner class KeepListener : KeepAdapter.KeepListener {
        override fun onClickHeart(item: KeepModel, isHeart: Boolean) {
            when (isHeart) {
                true -> keepViewModel.insertHeart(item)
                false -> keepViewModel.deleteHeart(item.thumbnailUrl)
            }
            val heartGuid = if (isHeart) "보관하였습니다." else "보관 취소하였습니다."
            Toast.makeText(context, heartGuid, Toast.LENGTH_SHORT).show()
        }

    }
}