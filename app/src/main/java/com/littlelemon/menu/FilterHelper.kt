package com.littlelemon.menu

class FilterHelper {//TODO create a FilterHelperTest and write a unit test for filterProducts

    fun filterProducts(type: FilterType, productsList: List<ProductItem>): List<ProductItem> {

        return when (type) {
            FilterType.Dessert -> productsList.filter { productItem ->
                productItem.category.equals(
                    DESSERT,
                    ignoreCase = true
                )
            }

            FilterType.Drinks -> productsList.filter { productItem ->
                productItem.category.equals(
                    DRINKS,
                    ignoreCase = true
                )
            }

            FilterType.Food -> productsList.filter { productItem ->
                productItem.category.equals(
                    FOOD,
                    ignoreCase = true
                )
            }

            FilterType.All -> productsList
        }

    }

    companion object {
        const val DESSERT = "dessert"
        const val DRINKS = "drinks"
        const val FOOD = "food"
    }

}