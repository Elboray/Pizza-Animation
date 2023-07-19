package com.example.pizzaanimation.ui.home_screen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pizzaanimation.R
import com.example.pizzaanimation.ui.theme.MintGreen
import kotlin.math.cos
import kotlin.math.sin

@SuppressLint("RememberReturnType")
@Composable
fun ComponentScreen(imageComponent: List<Ingredient>, onCLickImage: (Int) -> Unit) {
    Column(
        modifier = Modifier.padding(start = 24.dp, top = 550.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .wrapContentHeight(),
            text = "CUSTOMIZE YOUR PIZZA",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontWeight = FontWeight(600),
                color = Color.Black,
            )
        )


        LazyRow(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            items(imageComponent.size) { index ->

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageComponent[index].image)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .clickable {
                            onCLickImage(index)
                        }
                        .background(

                            color = if (imageComponent[index].isSelected) {
                                MintGreen
                            } else Color.Transparent,
                            shape = RoundedCornerShape(size = 25.dp)
                        ),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandableImages(
    expandedImages: List<Int>,
    isSelected:Boolean
) {
    AnimatedVisibility(
        visible = isSelected,
        enter = scaleIn(
            initialScale = 10f,
        ) + fadeIn(),
        exit = fadeOut(),
        modifier = Modifier.padding(top = 16.dp)
    )
  {
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .padding(start = 140.dp, top = 130.dp)
                .size(180.dp)
        ) {
            val angleDelta = 360f / expandedImages.size
            val radius = 55.dp

            expandedImages.forEachIndexed { index, expandedImage ->
                val angle = (index * angleDelta)
                val x = radius * cos(Math.toRadians(angle.toDouble())).toFloat()
                val y = radius * sin(Math.toRadians(angle.toDouble())).toFloat()
                Image(
                    painter = painterResource(expandedImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .offset { IntOffset(x = x.roundToPx(), y.roundToPx()) }
                        .clip(CircleShape),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}

