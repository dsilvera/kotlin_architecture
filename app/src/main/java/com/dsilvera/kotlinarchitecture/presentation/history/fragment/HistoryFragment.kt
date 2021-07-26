package com.dsilvera.kotlinarchitecture.presentation.history.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dsilvera.kotlinarchitecture.R
import com.dsilvera.kotlinarchitecture.domain.entity.Product
import com.dsilvera.kotlinarchitecture.domain.resource.Resource
import com.dsilvera.kotlinarchitecture.presentation.common.extension.mainNavController
import com.dsilvera.kotlinarchitecture.presentation.history.adapter.HistoryAdapter
import com.dsilvera.kotlinarchitecture.presentation.history.viewmodel.HistoryViewModel
import kotlinx.android.synthetic.main.fragment_history.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment() {
    private val viewModel: HistoryViewModel by viewModel()
    private val adapter = HistoryAdapter(object : HistoryAdapter.Interactor {
        override fun onProductClicked(product: Product) {
            mainNavController().navigate(HistoryFragmentDirections.actionHistoryToProduct(product))
        }
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewObserver()
        initView()
        refresh()
    }

    private fun initView() {
        historyBackButton.setOnClickListener {
            activity?.onBackPressed()
        }

        historyRecyclerView.adapter = adapter
    }

    private fun refresh() {
        viewModel.getAllProducts()
    }

    private fun initViewObserver() {
        viewModel.getAllProductsResult.observe(viewLifecycleOwner) {
            if (it is Resource.Success) adapter.setData(it.data)
        }
    }
}