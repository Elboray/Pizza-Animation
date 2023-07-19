package com.example.pizzaanimation.ui.home_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SuggestionChipLayout(selectedChip: String, onChipSelected: (String) -> Unit) {

    val animatedFloat by animateFloatAsState(
        targetValue = when (selectedChip) {
            "S"-> -1f
            "M" -> 0f
            "L" -> 1f
            else -> {-1f}
        }
    )

   Box(modifier = Modifier.wrapContentSize().offset(x = 20.dp, y = 220.dp), contentAlignment = BiasAlignment(animatedFloat , 1f)) {
       Box( modifier = Modifier
           .padding(end = 25.dp)
           .size(45.dp)
           .shadow(
               elevation = 4.dp,
               shape = RoundedCornerShape(25.dp),
               clip = true
           )
           .background(color = Color.White, shape = RoundedCornerShape(25.dp)),) {
           
       }

       Row(
           modifier = Modifier
         ,
           verticalAlignment = Alignment.CenterVertically,
       ) {

           ClickableChip(
               label ="S",
               selected = "S" == selectedChip,
               onChipChange = { onChipSelected(it) }
           )
           ClickableChip(
               label = "M",
               selected = "M" == selectedChip,
               onChipChange = { onChipSelected(it) }
           )
           ClickableChip(
               label = "L",
               selected = "L" == selectedChip,
               onChipChange = { onChipSelected(it) }
           )
       }
   }

}
