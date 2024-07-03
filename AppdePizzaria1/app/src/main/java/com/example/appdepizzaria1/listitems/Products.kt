package com.example.appdepizzaria1.listitems

import com.example.appdepizzaria1.R
import com.example.appdepizzaria1.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Products {

    private val _productList = MutableStateFlow<MutableList<Product>>(mutableListOf())
    private val productListFlow: StateFlow<MutableList<Product>> = _productList

    fun getProducts(): Flow<MutableList<Product>> {
        val productList: MutableList<Product> = mutableListOf(
            Product(
                imgProduct = R.drawable.cheese_pizza,
                name = "Pizza Mussarela",
                price = "36.50"
            ),
            Product(
                imgProduct = R.drawable.mixed_pizza,
                name = "Pizza Mixed",
                price = "45.50"
            ),
            Product(
                imgProduct = R.drawable.salmon_pizza,
                name = "Salmon Pizza",
                price = "50.50"
            ),
            Product(
                imgProduct = R.drawable.classic_pizza,
                name = "Pizza Classica",
                price = "32.90"
            )
        )
        _productList.value = productList
        return productListFlow

    }
}
