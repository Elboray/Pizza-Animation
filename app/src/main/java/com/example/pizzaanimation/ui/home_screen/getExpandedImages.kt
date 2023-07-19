package com.example.pizzaanimation.ui.home_screen

import com.example.pizzaanimation.R
import java.util.Random

fun getRandomExpandedImages(index: Int): List<Int> {
    val random = Random()

    val basilExpandedImages = listOf(
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
    val sausageExpandedImages = listOf(
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

    val broccoliExpandedImages = listOf(
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
    val onionExpandedImages = listOf(
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
    val mushroomExpandedImages = listOf(
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
    val expandedImagesList = when (index) {
        0 -> basilExpandedImages
        1 -> sausageExpandedImages
        2 -> broccoliExpandedImages
        3 -> onionExpandedImages
        4 -> mushroomExpandedImages
        else -> emptyList()
    }

    val shuffledList = expandedImagesList.shuffled(random)

    return shuffledList.subList(0, 10)


}
