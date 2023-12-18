package com.littlelemon.menu

import com.littlelemon.menu.R
import junit.framework.TestCase.assertEquals
import org.junit.Test

class FilterHelperTest {

    @Test
    fun filterProducts_filterTypeDessert_croissantReturned() {
        val sampleProductsList = mutableListOf(
            ProductItem(
                title = "Black tea",
                price = 3.00,
                category = "Drinks",
                R.drawable.black_tea
            ),
            ProductItem(
                title = "Croissant",
                price = 7.00,
                category = "Dessert",
                R.drawable.croissant
            ),
            ProductItem(
                title = "Bouillabaisse",
                price = 20.00,
                category = "Food",
                R.drawable.bouillabaisse
            )
        )
        assertEquals(
            classUnderTest.filterProducts(FilterType.Dessert, sampleProductsList)
                .map { productItem -> productItem.title }[0], "Croissant"
        )
    }

    @Test
    fun filterProducts_filterTypeDessert_foodReturned() {
        val sampleProductsList = mutableListOf(
            ProductItem(
                title = "Black tea",
                price = 3.00,
                category = "Drinks",
                R.drawable.black_tea
            ),
            ProductItem(
                title = "Croissant",
                price = 7.00,
                category = "Dessert",
                R.drawable.croissant
            ),
            ProductItem(
                title = "Bouillabaisse",
                price = 20.00,
                category = "Food",
                R.drawable.bouillabaisse
            )
        )
        assertEquals(
            classUnderTest.filterProducts(FilterType.Food, sampleProductsList)
                .map { productItem -> productItem.title }[0], "Bouillabaisse"
        )
    }

    @Test
    fun filterProducts_filterTypeDessert_drinksReturned() {
        val sampleProductsList = mutableListOf(
            ProductItem(
                title = "Black tea",
                price = 3.00,
                category = "Drinks",
                R.drawable.black_tea
            ),
            ProductItem(
                title = "Croissant",
                price = 7.00,
                category = "Dessert",
                R.drawable.croissant
            ),
            ProductItem(
                title = "Bouillabaisse",
                price = 20.00,
                category = "Food",
                R.drawable.bouillabaisse
            )
        )
        assertEquals(
            classUnderTest.filterProducts(FilterType.Drinks, sampleProductsList)
                .map { productItem -> productItem.title }[0], "Black tea"
        )
    }

    companion object {
        val classUnderTest = FilterHelper()
    }
}