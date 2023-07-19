package com.example.pizzaanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pizzaanimation.ui.home_screen.HomeScreenContent
import com.example.pizzaanimation.ui.theme.PizzaAnimationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaAnimationTheme {
                HomeScreenContent()
            }
        }
    }
}