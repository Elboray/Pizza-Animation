package com.example.pizzaanimation.ui.home_screen

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaanimation.R

@Composable
fun ClickableChip(
    label: String,
    selected: Boolean,
    onChipChange: (String) -> Unit
) {

    Box(
        modifier = Modifier
            .padding(end = 25.dp)
            .size(45.dp)
            .clickable { onChipChange(label) }
            .shadow(
                elevation = 0.dp,
                shape = RoundedCornerShape(25.dp),
                clip = true
            )
            .background(color = Color.White, shape = RoundedCornerShape(25.dp)),
        contentAlignment = Alignment.Center,
        content = {
            Text(
                modifier = Modifier,
                text = label,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    fontWeight = FontWeight(600),
                    color = Color.Black
                )
            )
        }
    )
}
