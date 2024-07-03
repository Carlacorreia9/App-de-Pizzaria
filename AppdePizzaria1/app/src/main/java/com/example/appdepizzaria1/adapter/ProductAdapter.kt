package com.example.appdepizzaria1.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdepizzaria1.ProductDetails
import com.example.appdepizzaria1.databinding.ProductItemBinding
import com.example.appdepizzaria1.model.Product

class ProductAdapter(private val context: Context, private val productList: MutableList<Product>):
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ProductViewHolder {
        val listItem = ProductItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProductViewHolder(listItem)
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
    holder.imgProduct.setBackgroundResource(productList[position].imgProduct)
    holder.name.text = productList[position].name
    holder.price.text= productList[position].price

        //Event Click
       holder.btAdd.setOnClickListener {
           val intent = Intent(context,ProductDetails::class.java)
           intent.putExtra("imgProduct",productList[position].imgProduct)
           intent.putExtra("name",productList[position].name)
           intent.putExtra("price",productList[position].price)
           context.startActivity(intent)
       }
}


    inner class  ProductViewHolder(binging: ProductItemBinding): RecyclerView.ViewHolder(binging.root) {
        val imgProduct = binging.imgProduct
        val name = binging.txtName
        val price = binging.txtPrice
        val btAdd = binging.btAdd
    }}




