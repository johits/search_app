package com.torder.search_app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.torder.search_app.R
import com.torder.search_app.databinding.ActivityMainBinding
import com.torder.search_app.presentation.keep.KeepFragment
import com.torder.search_app.presentation.search.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentTransaction(SearchFragment())
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            tvSearch.setOnClickListener {
                fragmentTransaction(SearchFragment())
            }

            tvKeep.setOnClickListener {
                fragmentTransaction(KeepFragment())
            }
        }
    }

    private fun fragmentTransaction(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fcv_fragment, fragment)
            commitAllowingStateLoss()
        }
    }
}