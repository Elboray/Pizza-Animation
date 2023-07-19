package com.example.pizzaanimation.ui.home_screen

import androidx.lifecycle.ViewModel
import com.example.pizzaanimation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        _state.update {
            it.copy(
                bread = getBread()
            )
        }
    }

    private fun getBread(): List<BreadUiState> {
        return listOf(
            BreadUiState(0, BreadSize.SMALL, getIngredient(), R.drawable.bread_1),
            BreadUiState(1, BreadSize.SMALL, getIngredient(), R.drawable.bread_2),
            BreadUiState(2, BreadSize.SMALL, getIngredient(), R.drawable.bread_3),
            BreadUiState(3, BreadSize.SMALL, getIngredient(), R.drawable.bread_4),
            BreadUiState(4, BreadSize.SMALL, getIngredient(), R.drawable.bread_5),
        )
    }

    private fun getIngredient(): List<Ingredient> {
        return listOf(
            Ingredient(
                0, false, R.drawable.basil_2,
                listOf(
                    R.drawable.basil_1,
                    R.drawable.basil_2,
                    R.drawable.basil_3,
                    R.drawable.basil_4,
                    R.drawable.basil_5,
                    R.drawable.basil_6,
                    R.drawable.basil_7,
                    R.drawable.basil_8,
                    R.drawable.basil_9,
                    R.drawable.basil_10
                )
            ),
            Ingredient(
                1, false, R.drawable.sausage_2,
                listOf(
                    R.drawable.sausage_1,
                    R.drawable.sausage_2,
                    R.drawable.sausage_3,
                    R.drawable.sausage_4,
                    R.drawable.sausage_5,
                    R.drawable.sausage_6,
                    R.drawable.sausage_7,
                    R.drawable.sausage_8,
                    R.drawable.sausage_9,
                    R.drawable.sausage_10
                )
            ),
            Ingredient(
                2, false, R.drawable.broccoli_2,
                listOf(
                    R.drawable.broccoli_1,
                    R.drawable.broccoli_2,
                    R.drawable.broccoli_3,
                    R.drawable.broccoli_4,
                    R.drawable.broccoli_5,
                    R.drawable.broccoli_6,
                    R.drawable.broccoli_7,
                    R.drawable.broccoli_8,
                    R.drawable.broccoli_9,
                    R.drawable.broccoli_10
                )
            ),
            Ingredient(
                3, false, R.drawable.onion_2,
                listOf(
                    R.drawable.onion_1,
                    R.drawable.onion_2,
                    R.drawable.onion_3,
                    R.drawable.onion_4,
                    R.drawable.onion_5,
                    R.drawable.onion_6,
                    R.drawable.onion_7,
                    R.drawable.onion_8,
                    R.drawable.onion_9,
                    R.drawable.onion_10
                )
            ),
            Ingredient(
                4, false, R.drawable.mushroom_2,
                listOf(
                    R.drawable.mushroom_1,
                    R.drawable.mushroom_2,
                    R.drawable.mushroom_3,
                    R.drawable.mushroom_4,
                    R.drawable.mushroom_5,
                    R.drawable.mushroom_6,
                    R.drawable.mushroom_7,
                    R.drawable.mushroom_8,
                    R.drawable.mushroom_9,
                    R.drawable.mushroom_10
                )
            )
        )
    }

    fun onClickImage(IngredientIndex: Int, breadIndex: Int) {
        _state.update {
            val breads = it.bread.toMutableList()
            val bread = breads[breadIndex]
            val Ingredients = bread.Ingredient.toMutableList()
            val Ingredient = Ingredients[IngredientIndex]

            Ingredients[IngredientIndex] = Ingredient.copy(
                isSelected = !Ingredient.isSelected,
            )

            breads[breadIndex] = bread.copy(
                Ingredient = Ingredients,

                )

            it.copy(
                bread = breads,
            )
        }

    }
}