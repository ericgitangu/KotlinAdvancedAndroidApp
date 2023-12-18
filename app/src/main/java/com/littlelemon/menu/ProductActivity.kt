package com.littlelemon.menu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.littlelemon.menu.MainActivity.Companion.KEY_CATEGORY
import com.littlelemon.menu.MainActivity.Companion.KEY_IMAGE
import com.littlelemon.menu.MainActivity.Companion.KEY_PRICE
import com.littlelemon.menu.MainActivity.Companion.KEY_TITLE

class ProductActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productItem =
            //todo replace with the passed values from intent
            ProductItem(
                intent.getStringExtra(KEY_TITLE)!!,
                intent.getDoubleExtra(KEY_PRICE,0.00),
                intent.getStringExtra(KEY_CATEGORY)!!,
                intent.getIntExtra(KEY_IMAGE, 0)
            )
        setContent { ProductDetails(productItem) }
    }
}
