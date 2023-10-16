package com.torder.search_app.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.coroutineScope

abstract class CommonFragment<B : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
) : Fragment() {
    lateinit var binding: B
        private set

    protected val LifecycleOwner.lifecycleScope: LifecycleCoroutineScope
        get() = lifecycle.coroutineScope

    open fun onInitBinding() {}
    open fun observeData() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<B>(inflater, layoutResId, container, false).apply {
            root.animation = AlphaAnimation(0f, 1f).apply {
                duration = 250
            }
        }
        onInitBinding()
        observeData()
        return binding.root
    }
}