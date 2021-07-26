package com.dsilvera.kotlinarchitecture.presentation.product.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.dsilvera.kotlinarchitecture.R
import kotlinx.android.synthetic.main.fragment_product.*

class ProductFragment : Fragment() {
    private val arguments: ProductFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product = arguments.product
        Glide.with(productImage.context).load(product.imageUrl).into(productImage)
        productName.text = product.genericName
        productEcoScore.text = getString(R.string.ecoscore, product.ecoscoreScore.toString())
        productNutriScore.text = getString(R.string.nutriscore, product.nutriscoreScore.toString())
        productScore.text = getString(R.string.product_score, product.score().toString())

        productBrand.text = product.brand
        productLabels.text = product.labels
        productIngredientsText.text = product.ingredientsText

        productBackButton.setOnClickListener {
            activity?.onBackPressed()
        }

    }
}