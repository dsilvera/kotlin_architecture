package com.dsilvera.kotlinarchitecture.presentation.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dsilvera.kotlinarchitecture.R
import com.dsilvera.kotlinarchitecture.presentation.common.extension.mainNavController
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeScan.setOnClickListener{
            mainNavController().navigate(HomeFragmentDirections.actionHomeToScan())
        }
        homeHistory.setOnClickListener{
            mainNavController().navigate(HomeFragmentDirections.actionHomeToHistory())
        }
    }
}