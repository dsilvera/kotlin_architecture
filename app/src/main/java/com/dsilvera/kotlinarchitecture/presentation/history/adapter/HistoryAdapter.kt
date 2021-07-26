package com.dsilvera.kotlinarchitecture.presentation.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dsilvera.kotlinarchitecture.R
import com.dsilvera.kotlinarchitecture.domain.entity.Product
import kotlinx.android.synthetic.main.item_product.view.*

class HistoryAdapter(private val interactor: Interactor) :
    RecyclerView.Adapter<HistoryAdapter.ProductViewHolder>() {
    private val products = ArrayList<Product>()

    fun setData(data: List<Product>) {
        products.clear()
        products.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProductViewHolder(inflater, parent) {
            interactor.onProductClicked(it)
        }
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount() = products.size


    class ProductViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        private val onClick: (Product) -> Unit
    ) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_product, parent, false)) {
        private var data: Product? = null

        init {
            itemView.setOnClickListener {
                data?.let { product -> onClick.invoke(product) }
            }
        }

        fun bind(product: Product) {
            data = product

            itemView.productName.text = product.genericName
            Glide.with(itemView.context).load(product.imageUrl).into(itemView.productImage)
        }
    }

    interface Interactor {
        fun onProductClicked(product: Product)
    }
}

