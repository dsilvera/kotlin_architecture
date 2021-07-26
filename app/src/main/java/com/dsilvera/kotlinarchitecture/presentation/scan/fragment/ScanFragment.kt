package com.dsilvera.kotlinarchitecture.presentation.scan.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dsilvera.kotlinarchitecture.R
import com.dsilvera.kotlinarchitecture.domain.resource.Resource
import com.dsilvera.kotlinarchitecture.presentation.common.extension.mainNavController
import com.dsilvera.kotlinarchitecture.presentation.product.viewmodel.ScanViewModel
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.fragment_scan.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScanFragment : Fragment() {
    private val viewModel: ScanViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewObserver()
        IntentIntegrator.forSupportFragment(this).setOrientationLocked(true).initiateScan()

        scanBackButton.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun initViewObserver(){
        viewModel.getProductResult.observe(viewLifecycleOwner, {
            if (it is Resource.Success) {
                mainNavController().navigate(ScanFragmentDirections.actionScanToProduct(it.data))
            } else  if (it is Resource.Failure) {
                Toast.makeText(context, it.throwable.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                viewModel.getProduct(result.contents)
            }
        }
    }
}