package com.example.appdepizzaria1

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appdepizzaria1.adapter.ProductAdapter
import com.example.appdepizzaria1.databinding.ActivityMainBinding
import com.example.appdepizzaria1.listitems.Products
import com.example.appdepizzaria1.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding
        private lateinit var productAdapter: ProductAdapter
        private val products = Products()
        private val productList: MutableList<Product> = mutableListOf()
        var clicked = false

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#E0E0E0")
        CoroutineScope(Dispatchers.IO).launch {
            products.getProducts().collectIndexed { index, value ->
                for (p in value){
                    productList.add(p)

                }
            }

        }

        val recyclerViewProducts = binding.recyclerViewProducts
        recyclerViewProducts.layoutManager = GridLayoutManager(this,2)
        recyclerViewProducts.setHasFixedSize(true)
        productAdapter = ProductAdapter(this,productList)
        recyclerViewProducts.adapter = productAdapter

        binding.btAll.setOnClickListener{
            clicked = true
            if (clicked){
                binding.btAll.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btAll.setTextColor(Color.WHITE)
                binding.btChicken.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btChicken.setTextColor(R.color.dark_gray)
                binding.btKebab.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btKebab.setTextColor(R.color.dark_gray)
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPizza.setTextColor(R.color.dark_gray)
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "All"
            }
            binding.btChicken.setOnClickListener{
                clicked = true
                if (clicked){

                    binding.btChicken.setBackgroundResource(R.drawable.bg_button_enabled)
                    binding.btChicken.setTextColor(Color.WHITE)
                    binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                    binding.btAll.setTextColor(R.color.dark_gray)
                    binding.btKebab.setBackgroundResource(R.drawable.bg_button_disabled)
                    binding.btKebab.setTextColor(R.color.dark_gray)
                    binding.btPizza.setBackgroundResource(R.drawable.bg_button_disabled)
                    binding.btPizza.setTextColor(R.color.dark_gray)
                    binding.recyclerViewProducts.visibility = View.INVISIBLE
                    binding.txtListTitle.text = "Chicken"}
        }
        binding.btPizza.setOnClickListener{
            clicked = true
            if (clicked){
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btPizza.setTextColor(Color.WHITE)
                binding.btChicken.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btChicken.setTextColor(R.color.dark_gray)
                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.dark_gray)
                binding.btKebab.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btKebab.setTextColor(R.color.dark_gray)
                binding.recyclerViewProducts.visibility = View.VISIBLE
                binding.txtListTitle.text = "Popular Pizza"}
        }}
        binding.btKebab.setOnClickListener{
            clicked = true
            if (clicked){
                binding.btKebab.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btKebab.setTextColor(Color.WHITE)
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPizza.setTextColor(R.color.dark_gray)
                binding.btChicken.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btChicken.setTextColor(R.color.dark_gray)
                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.dark_gray)
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Kebab"}
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }}
