package com.littlelemon.menu

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.view.MenuCompat
import com.littlelemon.menu.ProductsWarehouse.productsList
import com.littlelemon.menu.ProductsWarehouse.productsState
import kotlinx.coroutines.flow.update

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val products by productsState.collectAsState()
            ProductsGrid(products = products, startProductActivity = this::startProductActivity)
        }
    }

    private fun startProductActivity(productItem: ProductItem) {
        //TODO instantiate intent and pass extra parameter from product
        val intent = Intent(this, ProductActivity::class.java).apply {
            putExtra(KEY_CATEGORY, productItem.category)
            putExtra(KEY_IMAGE, productItem.image)
            putExtra(KEY_PRICE, productItem.price)
            putExtra(KEY_TITLE, productItem.title)
        }
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.products_menu, menu)
        menu?.let { MenuCompat.setGroupDividerEnabled(it, true) }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.groupId == R.id.sorting) {
            val type = when (item.itemId) {
                R.id.sort_a_z -> SortType.Alphabetically
                R.id.sort_price_asc -> SortType.PriceAsc
                R.id.sort_price_desc -> SortType.PriceDesc
                else -> SortType.Alphabetically
            }
            productsState.update {
                Products(
                    SortHelper().sortProducts(
                        type,
                        productsList
                    )
                )
            }
        } else if (item.groupId == R.id.filter) {
            val type = when (item.itemId) {
                R.id.filter_all -> FilterType.All
                R.id.filter_drinks -> FilterType.Drinks
                R.id.filter_food -> FilterType.Food
                R.id.filter_dessert -> FilterType.Dessert
                else -> FilterType.All
            }
            productsState.update {
                Products(
                    FilterHelper().filterProducts(
                        type,
                        productsList
                    )
                )
            }
        }
        return true
    }

    companion object {
        const val KEY_TITLE = "title"
        const val KEY_PRICE = "price"
        const val KEY_IMAGE = "image"
        const val KEY_CATEGORY = "category"
    }
}