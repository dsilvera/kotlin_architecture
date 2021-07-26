package com.dsilvera.kotlinarchitecture.presentation.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dsilvera.kotlinarchitecture.R
import com.dsilvera.kotlinarchitecture.presentation.common.extension.mainNavController
import com.dsilvera.kotlinarchitecture.presentation.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        homeScan.setOnClickListener{
            mainNavController().navigate(HomeFragmentDirections.actionHomeToScan())
        }
        homeHistory.setOnClickListener{
            mainNavController().navigate(HomeFragmentDirections.actionHomeToHistory())
        }
        refreshScore(viewModel.getScore())
    }

    private fun initViewModel() {
        viewModel.scoreUpdateEvent.observe(viewLifecycleOwner) {
            refreshScore(it.score)
        }
    }

    private fun refreshScore(score: Int) {
        homeScore.text = getString(R.string.score, score.toString())
    }
}