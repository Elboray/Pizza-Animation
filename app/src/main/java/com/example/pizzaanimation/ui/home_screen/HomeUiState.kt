package com.example.pizzaanimation.ui.home_screen

data class HomeUiState(
    val bread: List<BreadUiState> = emptyList(),

    )

data class BreadUiState(
    val id: Int = 0,
    val size: BreadSize = BreadSize.SMALL,
    val Ingredient: List<Ingredient> = emptyList(),
    val image: Int = 0,
)

enum class BreadSize {
    SMALL,
    MEDIUM,
    LARGE
}

data class Ingredient(
    val id: Int = 0,
    val isSelected: Boolean = false,
    val image: Int = 0,
    val component: List<Int> = emptyList(),
)
